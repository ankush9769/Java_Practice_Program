use ankush;
select * from emp;
Delimiter //
create or replace procedure Demo()
begin
select  * from emp ;
end //
delimiter ;

call Demo();

Delimiter //
create or replace procedure GetEmp(In dept_name varchar (50))
 begin
select  * from emp where dept = dept_name ;
end //
delimiter ;

call GetEmp('HR')
  
  Delimiter //  -- Total number of employees 
  create or replace procedure get_emp(out total_count bigint)
  begin
   select count(*) into total_count from emp ;
   end//
delimiter ;
call get_emp(@count);-- Global variable should be declared with @. 
select @count ;
desc emp;

delimiter // -- Total number of employees in the IT department. 
 create or replace procedure get_deptemp(in dept_n varchar(20),out total_count bigint)
  begin
   select count(*) into total_count from emp where dept=dept_n ;
   end//
delimiter ;
call get_deptemp('IT',@countdeptemp);
select @countdeptemp;
select * from emp;


delimiter // -- Total number of employees of each department 
 create or replace procedure get_deptempall()
  begin
   select count(*) as total_emp from emp group by dept ;
   end//
delimiter ;
call get_deptempall();


delimiter //  -- Total sum of salary of a specific department 
 create or replace procedure get_totalsalary(in dept_n varchar(20),out total_salary decimal(10,2))
  begin
   select sum(salary) into total_salary from emp where dept=dept_n ;
   end//
delimiter ;
call get_totalsalary('IT',@total_sal);
select @total_sal;



-- Increment the salary of the employee by a certain percentage.
delimiter // 
create or replace procedure increament_sal(in empid int,in percent decimal(10,2))
begin
 update emp set salary = salary+(salary*percent) where id = empid;
 select * from emp;
end//
delimiter ;
call increament_sal(103,0.1);

-- If salary is less than 80,000 then increment by 10%. If the salary is greater than 80,000 then increment by 20%. 

delimiter //
create or replace procedure calculate_bonus(in emp_id int,out bonus decimal(10,2))
begin
declare emp_salary decimal(10,2);
select salary into emp_salary from emp where id=emp_id;

if emp_salary>=80000 then 
   set bonus = 0.2;
else set bonus = 0.1;
end if;
end//
delimiter ;

call calculate_bonus(103,@bonus);
select @bonus;



-- stored procedure has multiple in and multiple out
-- we can use 
-- Why are stored procedures faster?
-- 1 precompiled execution plan 
-- 2 reduce network traffic
-- 3 login executes on database server

-- # handling exception with help of stored procedure
declare handler_action handler for condition_value handler_exception statment
eg..   declare EXIT handler for SQLEXCEPTION
-- handler_action => uses exit to stop execution of a blok or continue to keep running
-- condition_value => it uses genaric classes like sqlexception is handler for all else,sqlwarning(this for warning),not found(no rows / end of cursor),signal(similar to throw in java it tell my sql  to stop execution and generate an error)
-- sql_state=> its 5 character error code 
-- mysql uses sql state to chatagories the error
02000 => no data found
23000 => constraints voilated
42000 => syntax error
45000 => user define exception







-- Problem Statement 
-- We are creating the order management systems. Basically we have three tables:
-- - order
-- - inventory management
-- - audit log

select * from orders;
create table orders1(
order_id int auto_increment primary key,
product_id int,
quantity int,
order_date datetime
);
INSERT INTO orders1 (product_id, quantity, order_date) VALUES 
(101, 2,NOW()),
(105, 1, NOW()),
(102, 5, NOW()),
(104, 3, NOW()),
(101, 1,NOW()),
(103, 10,NOW());

create table inventory1(
product_id int primary key,
stock_qty int
);
INSERT INTO inventory1 (product_id, stock_qty) VALUES 
(101, 45),
(102, 12),
(103, 8),
(104, 23),
(105, 50),
(106, 100);

create table audit_log(
audit_id int primary key auto_increment,
action_type varchar(50),
description varchar(255),
created_at datetime);
insert into audit_log(action_type,description,created_at)values
('order','initial order for product 101',now()),
('order','initial order for product 102',now()),
('order','initial order for product 103',now()),
('order','initial order for product 104',now()),
('order','initial order for product 105',now());

select * from inventory1;
select * from orders1;
select * from audit_log;
delimiter //
create  procedure orderPlace(in p_product_id int,in p_quantity int)
begin
     declare v_stock int;
     declare v_order_id int;
     
     declare EXIT handler for SQLEXCEPTION
     begin
          rollback;
          SIGNAL SQLSTATE '45000'
          set MESSAGE_TEXT = "order processing failed.transation rolled back";
     END;
     
     start TRANSACTION;
     select stock_qty into v_stock from inventory1 where product_id = p_product_id
     for UPDATE;
     
     if v_stock is null then
        SIGNAL SQLSTATE  '45000'
        set MESSAGE_TEXT = "product not found";
     END if;
     
     if v_stock < p_quantity then
        SIGNAL SQLSTATE  '45000'
        set MESSAGE_TEXT = "insufficient quantity";
     END if;
     
     insert into orders1(product_id,quantity,order_date) values
     (p_product_id,p_quantity,now());
     
     set v_order_id = LAST_INSERT_ID();
     
     update inventory1 set stock_qty = (stock_qty-p_quantity) where product_id = p_product_id;
     
     INSERT INTO audit_log(action_type,description,created_at) values
     ('ordered',CONCAT('initial order for product ',p_product_id),now());
     
     COMMIT;
END //
delimiter ;     

call orderPlace(101,40);
     
     
     
     
        
        













 