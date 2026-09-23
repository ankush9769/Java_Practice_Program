/*
 * Employee leave procedures.
 * These are intentionally separate from LeaveFeatureProcedures.sql.
 * Existing procedures are not modified by this file.
 */

/*
 * Employee leave procedures.
 * These are intentionally separate from LeaveFeatureProcedures.sql.
 * Existing procedures are not modified by this file.
 */

DROP PROCEDURE IF EXISTS GetEmployeeLeaveBalances;
DROP PROCEDURE IF EXISTS GetEmployeeLeaveRequests;
DROP PROCEDURE IF EXISTS ApplyEmployeeLeave;

DELIMITER //

CREATE PROCEDURE GetEmployeeLeaveBalances(IN p_userId INT)
BEGIN
    SELECT
        m.LeaveTypeId,
        m.LeaveType,
        COALESCE(b.TotalLeaves, dl.LeavesCount, 0) AS TotalLeaves,
        COALESCE(b.UsedLeaves, 0) AS UsedLeaves,
        GREATEST(COALESCE(b.TotalLeaves, dl.LeavesCount, 0) - COALESCE(b.UsedLeaves, 0), 0) AS RemainingLeaves
    FROM `User` u
    INNER JOIN DepartmentLeaves dl
        ON dl.DepartmentId = u.DepartmentId
       AND LOWER(COALESCE(dl.Status, 'Active')) = 'active'
    INNER JOIN MasterLeaveTypes m
        ON m.LeaveTypeId = dl.LeaveTypeId
    LEFT JOIN LeaveBalances b
        ON b.UserId = p_userId
       AND b.DepartmentLeavesId = dl.DepartmentLeavesId
       AND b.LeaveTypeId = dl.LeaveTypeId
    WHERE u.UserId = p_userId
      AND LOWER(COALESCE(u.Status, 'Active')) = 'active'
    ORDER BY m.LeaveType ASC, m.LeaveTypeId ASC;
END //

CREATE PROCEDURE GetEmployeeLeaveRequests(
    IN p_userId INT,
    IN p_fromDate DATE,
    IN p_toDate DATE,
    IN p_leaveTypeId INT,
    IN p_status VARCHAR(50),
    IN p_sort VARCHAR(20)
)
BEGIN
    SELECT
        lr.LeaveRequestId,
        lr.UserId,
        lr.LeaveTypeId,
        m.LeaveType,
        lr.StartDate,
        lr.EndDate,
        lr.NumberOfDays,
        lr.Reason,
        lr.ApprovedBy,
        lr.Status,
        lr.StatusHistory
    FROM LeaveRequests lr
    INNER JOIN MasterLeaveTypes m
        ON m.LeaveTypeId = lr.LeaveTypeId
    WHERE lr.UserId = p_userId
      AND (p_fromDate IS NULL OR DATE(lr.EndDate) >= p_fromDate)
      AND (p_toDate IS NULL OR DATE(lr.StartDate) <= p_toDate)
      AND (p_leaveTypeId IS NULL OR lr.LeaveTypeId = p_leaveTypeId)
      AND (p_status IS NULL OR TRIM(p_status) = '' OR LOWER(lr.Status) = LOWER(TRIM(p_status)))
    ORDER BY
      CASE WHEN LOWER(COALESCE(p_sort, 'newest')) = 'oldest' THEN lr.StartDate END ASC,
      CASE WHEN LOWER(COALESCE(p_sort, 'newest')) <> 'oldest' THEN lr.StartDate END DESC,
      lr.LeaveRequestId DESC;
END //

CREATE PROCEDURE ApplyEmployeeLeave(
    IN p_userId INT,
    IN p_leaveTypeId INT,
    IN p_startDate DATE,
    IN p_endDate DATE,
    IN p_reason LONGTEXT
)
BEGIN
    DECLARE v_departmentLeavesId INT DEFAULT NULL;
    DECLARE v_totalLeaves INT DEFAULT 0;
    DECLARE v_usedLeaves INT DEFAULT 0;
    DECLARE v_requestedDays INT DEFAULT 0;
    DECLARE v_pendingDays INT DEFAULT 0;
    DECLARE v_overlapCount INT DEFAULT 0;
    DECLARE v_currentDate DATE;
    DECLARE v_approvedBy VARCHAR(255) DEFAULT 'Pending';

    IF p_startDate IS NULL OR p_endDate IS NULL THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Start date and end date are required.';
    END IF;

    IF p_startDate > p_endDate THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'End date cannot be before start date.';
    END IF;

    IF p_reason IS NULL OR TRIM(p_reason) = '' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Reason is required.';
    END IF;

    IF NOT EXISTS (
        SELECT 1 FROM `User`
        WHERE UserId = p_userId
          AND LOWER(COALESCE(Status, 'Active')) = 'active'
    ) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Employee account is not active.';
    END IF;

    IF NOT EXISTS (
        SELECT 1 FROM MasterLeaveTypes WHERE LeaveTypeId = p_leaveTypeId
    ) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Leave type not found.';
    END IF;

    IF EXISTS (
        SELECT 1
        FROM LeaveSettings
        WHERE LeaveTypeId = p_leaveTypeId
          AND IsActive = 0
    ) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'This leave type is inactive.';
    END IF;

    SELECT dl.DepartmentLeavesId
      INTO v_departmentLeavesId
      FROM `User` u
      INNER JOIN DepartmentLeaves dl
        ON dl.DepartmentId = u.DepartmentId
       AND dl.LeaveTypeId = p_leaveTypeId
       AND LOWER(COALESCE(dl.Status, 'Active')) = 'active'
      WHERE u.UserId = p_userId
      LIMIT 1;

    IF v_departmentLeavesId IS NULL THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'This leave type has not been allocated to your department.';
    END IF;

    SELECT
        COALESCE(b.TotalLeaves, dl.LeavesCount, 0),
        COALESCE(b.UsedLeaves, 0)
      INTO v_totalLeaves, v_usedLeaves
      FROM DepartmentLeaves dl
      LEFT JOIN LeaveBalances b
        ON b.UserId = p_userId
       AND b.DepartmentLeavesId = dl.DepartmentLeavesId
       AND b.LeaveTypeId = dl.LeaveTypeId
     WHERE dl.DepartmentLeavesId = v_departmentLeavesId
     LIMIT 1;

    /* A new employee may have joined after the department allocation was created.
       Create the missing balance from the current department allocation. */
    IF NOT EXISTS (
        SELECT 1 FROM LeaveBalances
         WHERE UserId = p_userId
           AND DepartmentLeavesId = v_departmentLeavesId
           AND LeaveTypeId = p_leaveTypeId
    ) THEN
        INSERT INTO LeaveBalances
            (UserId, DepartmentLeavesId, LeaveTypeId, TotalLeaves, UsedLeaves)
        VALUES
            (p_userId, v_departmentLeavesId, p_leaveTypeId, v_totalLeaves, 0);
    END IF;

    SET v_requestedDays = 0;
    SET v_currentDate = p_startDate;
    WHILE v_currentDate <= p_endDate DO
        /* DAYOFWEEK: 1 = Sunday. Sunday is a weekly holiday and is excluded. */
        IF DAYOFWEEK(v_currentDate) <> 1 THEN
            SET v_requestedDays = v_requestedDays + 1;
        END IF;
        SET v_currentDate = DATE_ADD(v_currentDate, INTERVAL 1 DAY);
    END WHILE;

    IF v_requestedDays <= 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The selected date range contains only Sunday holidays.';
    END IF;

    /* Do not allow overlapping active requests for the same employee. */
    SELECT COUNT(*)
      INTO v_overlapCount
      FROM LeaveRequests
     WHERE UserId = p_userId
       AND LOWER(Status) IN ('new', 'pending', 'approved')
       AND DATE(StartDate) <= p_endDate
       AND DATE(EndDate) >= p_startDate;

    IF v_overlapCount > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You already have a leave request overlapping the selected dates.';
    END IF;

    /* Pending requests reserve balance so an employee cannot submit beyond the allocation. */
    SELECT COALESCE(SUM(NumberOfDays), 0)
      INTO v_pendingDays
      FROM LeaveRequests
     WHERE UserId = p_userId
       AND LeaveTypeId = p_leaveTypeId
       AND LOWER(Status) IN ('new', 'pending');

    IF v_requestedDays + v_usedLeaves + v_pendingDays > v_totalLeaves THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Insufficient remaining leave balance for the selected dates.';
    END IF;

    INSERT INTO LeaveRequests
        (UserId, LeaveTypeId, StartDate, EndDate, NumberOfDays, Reason, ApprovedBy, Status, StatusHistory)
    VALUES
        (p_userId, p_leaveTypeId,
         CONCAT(p_startDate, ' 00:00:00'),
         CONCAT(p_endDate, ' 23:59:59'),
         v_requestedDays, TRIM(p_reason), v_approvedBy, 'New',
         CONCAT('Created by employee on ', DATE_FORMAT(NOW(), '%Y-%m-%d %H:%i:%s')));
END //

DELIMITER ;




use pulse360db;
select * from user;
select * from departmentleaves;
select * from masterleavetypes;