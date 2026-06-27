use ankush;
-- indexing is one of the imp concept for query optimizaion
-- an index is database object that help mysql find rows faster without scanning entire table

-- type of indexing
-- 1 cluster
-- 2 non cluster
-- 3 primary
-- 4 unique

-- binary B+tree  (balance)
-- heap 
-- fulltext
-- special


use Day1;
    
    -- composite primary key
 CREATE TABLE composite_table (
    id INT,
    name VARCHAR(255),
    email VARCHAR(255),
    number BIGINT,
    PRIMARY KEY (id, name)
);
SET SQL_SAFE_UPDATES = 0;
DELETE FROM composite_primary;
    INSERT INTO composite_table (id, name, email, number)
VALUES
(1, 'Rahul', 'rahul@gmail.com', 9876543210),
(1, 'Amit', 'amit@gmail.com', 9876543211),
(2, 'Priya', 'priya@gmail.com', 9876543212),
(2, 'Neha', 'neha@gmail.com', 9876543213),
(3, 'Rohan', 'rohan@gmail.com', 9876543214),
(3, 'Sneha', 'sneha@gmail.com', 9876543215),
(4, 'Vikas', 'vikas@gmail.com', 9876543216),
(4, 'Pooja', 'pooja@gmail.com', 9876543217),
(5, 'Arjun', 'arjun@gmail.com', 9876543218),
(5, 'Kiran', 'kiran@gmail.com', 9876543219);

INSERT INTO composite_primary (id, name, email, number)
VALUES
(6, 'Ankit', 'ankit@gmail.com', 111111),
(7, 'Riya', 'riya@gmail.com', 111112),
(8, 'Mohit', 'mohit@gmail.com', 111113),
(9, 'Simran', 'simran@gmail.com', 111114),
(10, 'Kunal', 'kunal@gmail.com', 111115),
(11, 'Aisha', 'aisha@gmail.com', 111116),
(12, 'Rakesh', 'rakesh@gmail.com', 111117),
(13, 'Divya', 'divya@gmail.com', 111118),
(14, 'Sahil', 'sahil@gmail.com', 111119),
(15, 'Nikita', 'nikita@gmail.com', 111120),
(16, 'Yash', 'yash@gmail.com', 111121),
(17, 'Meera', 'meera@gmail.com', 111122),
(18, 'Harsh', 'harsh@gmail.com', 111123),
(19, 'Pallavi', 'pallavi@gmail.com', 111124),
(20, 'Rohit', 'rohit@gmail.com', 111125),
(21, 'Tina', 'tina@gmail.com', 111126),
(22, 'Ajay', 'ajay@gmail.com', 111127),
(23, 'Komal', 'komal@gmail.com', 111128),
(24, 'Vivek', 'vivek@gmail.com', 111129),
(25, 'Sonia', 'sonia@gmail.com', 111130);

delete from composite_table where id  = 1;
select * from composite_table;

drop table emp;

create table emp(
id int primary key,
name varchar(50),
salary decimal(10,2),
dept varchar(52),
email varchar(255)
);

INSERT INTO emp (id, name, salary, dept, email) VALUES
(1,'Rahul Sharma',55000.00,'IT','rahul.sharma@gmail.com'),
(2,'Priya Verma',48000.00,'HR','priya.verma@gmail.com'),
(3,'Amit Kumar',62000.00,'Finance','amit.kumar@gmail.com'),
(4,'Neha Singh',45000.00,'Marketing','neha.singh@gmail.com'),
(5,'Rohan Gupta',70000.00,'IT','rohan.gupta@gmail.com'),
(6,'Sneha Patel',52000.00,'Sales','sneha.patel@gmail.com'),
(7,'Vikas Yadav',68000.00,'Finance','vikas.yadav@gmail.com'),
(8,'Anjali Mehta',47000.00,'HR','anjali.mehta@gmail.com'),
(9,'Karan Malhotra',75000.00,'IT','karan.m@gmail.com'),
(10,'Pooja Sharma',51000.00,'Marketing','pooja.sharma@gmail.com'),
(11,'Deepak Joshi',58000.00,'Sales','deepak.j@gmail.com'),
(12,'Simran Kaur',60000.00,'Finance','simran.k@gmail.com'),
(13,'Arjun Nair',65000.00,'IT','arjun.nair@gmail.com'),
(14,'Meera Iyer',49000.00,'HR','meera.iyer@gmail.com'),
(15,'Manish Jain',72000.00,'IT','manish.j@gmail.com'),
(16,'Ritika Das',46000.00,'Marketing','ritika.d@gmail.com'),
(17,'Sanjay Mishra',54000.00,'Sales','sanjay.m@gmail.com'),
(18,'Kavita Rao',63000.00,'Finance','kavita.r@gmail.com'),
(19,'Nikhil Sharma',69000.00,'IT','nikhil.s@gmail.com'),
(20,'Divya Kapoor',53000.00,'HR','divya.k@gmail.com'),
(21,'Yash Agarwal',61000.00,'Finance','yash.a@gmail.com'),
(22,'Komal Gupta',50000.00,'Marketing','komal.g@gmail.com'),
(23,'Abhishek Mishra',78000.00,'IT','abhishek.m@gmail.com'),
(24,'Ayesha Khan',55000.00,'Sales','ayesha.k@gmail.com'),
(25,'Mohit Saini',64000.00,'Finance','mohit.s@gmail.com'),
(26,'Ishita Roy',47000.00,'HR','ishita.r@gmail.com'),
(27,'Harsh Vardhan',71000.00,'IT','harsh.v@gmail.com'),
(28,'Naina Arora',52000.00,'Marketing','naina.a@gmail.com'),
(29,'Rakesh Pandey',56000.00,'Sales','rakesh.p@gmail.com'),
(30,'Shreya Bose',67000.00,'Finance','shreya.b@gmail.com'),
(31,'Aditya Singh',73000.00,'IT','aditya.s@gmail.com'),
(32,'Tanvi Chawla',49000.00,'HR','tanvi.c@gmail.com'),
(33,'Gaurav Saxena',62000.00,'Finance','gaurav.s@gmail.com'),
(34,'Muskan Jain',51000.00,'Marketing','muskan.j@gmail.com'),
(35,'Varun Arora',76000.00,'IT','varun.a@gmail.com'),
(36,'Sakshi Gupta',54000.00,'Sales','sakshi.g@gmail.com'),
(37,'Nitin Kumar',59000.00,'Finance','nitin.k@gmail.com'),
(38,'Riya Sharma',48000.00,'HR','riya.s@gmail.com'),
(39,'Ashish Verma',81000.00,'IT','ashish.v@gmail.com'),
(40,'Preeti Yadav',53000.00,'Marketing','preeti.y@gmail.com'),
(41,'Saurabh Mishra',57000.00,'Sales','saurabh.m@gmail.com'),
(42,'Payal Singh',65000.00,'Finance','payal.s@gmail.com'),
(43,'Vivek Gupta',74000.00,'IT','vivek.g@gmail.com'),
(44,'Anu Thomas',50000.00,'HR','anu.t@gmail.com'),
(45,'Hemant Kumar',68000.00,'Finance','hemant.k@gmail.com'),
(46,'Nidhi Sharma',52000.00,'Marketing','nidhi.s@gmail.com'),
(47,'Akash Patel',79000.00,'IT','akash.p@gmail.com'),
(48,'Bhavna Mehra',55000.00,'Sales','bhavna.m@gmail.com'),
(49,'Ravi Chauhan',61000.00,'Finance','ravi.c@gmail.com'),
(50,'Sonal Gupta',47000.00,'HR','sonal.g@gmail.com');

 explain analyze select * from emp where dept = 'HR';
 create index index_dept on emp(dept);
 show index from emp;
 
  -- drop index
 drop  index index_dept on emp;
 
  -- when should we use indexing ?
  --  where,group by,order by,join;
  
  
 --  Command	Purpose
SET GLOBAL slow_query_log = 'ON';	-- Enables the slow query log.
SHOW VARIABLES LIKE 'slow_query_log';	-- Checks whether the slow query log is enabled.
SET GLOBAL long_query_time = 2;	-- Logs queries that take more than 2 seconds.
SHOW VARIABLES LIKE 'long_query_time';	-- Displays the current slow query threshold.


Delimiter //

 create procedure Demo()
 begin
 
select  * from emp ;
end //
delimiter ;

call Demo();
Delimiter //
 create procedure GetEmp(In dept_name varchar (50))
 begin
 
select  * from emp where dept = dept_name ;
end //
delimiter ;

  call GetEmp('hr')
  
  Delimiter //
  create procedure get_emp(out total_count bigint)
  begin
   select count(*) into total_count from emp ;
   end//
   delimiter ;
    call get_emp(@count);
    select @count ;
    
    
     Delimiter //
  create procedure get_emp_dept(In dept_name varchar(50) ,out total_count bigint)
  begin
   select count(*) into total_count from emp where dept = dept_name ;
   end//
   delimiter ;
    call get_emp_dept('hr',@count);
    select @count ;
    
    drop procedure get_dept;
   delimiter //
   create procedure get_dept()
   begin
   select dept, count(*) from emp group by dept;
   end //
   delimiter ;
   
   call get_dept();
   
   
   delimiter //
    create procedure get_Avg_sal(in dept_name varchar (50))
   begin
   select sum(salary) as total_sum from emp where dept = dept_name;
   end //
   delimiter ;
   drop procedure get_Avg_sal;
   
   call get_Avg_sal('hr');
   
    delimiter //
    create procedure Update_sal(in emp_id int  , in hike decimal(5,2))
   begin
   update emp set salary = salary + (salary * hike)/100 where id = emp_id;
   select * from emp where id = emp_id;
   end //
   delimiter ;
  call Update_sal(10,5);
  drop procedure Update_sal;
  
   delimiter //
    create procedure Update_bonus(in emp_id int , out bonus decimal (10,2))
   begin
   declare emp_salary decimal(10,2);
   select salary into emp_salary from emp  where id  = emp_id;
   
   if emp_salary >=80000 then
   set bonus = emp_salary * 0.20;
   select * from emp where id = emp_id;
   else  set bonus = emp_salary * 0.10;
   select * from emp where id = emp_id;
   end if ;
   end //
   delimiter ;
   
  call Update_bonus(10,@bonus);
  
 drop table orders_table;
  
CREATE TABLE orders_table( id INT primary key, name VARCHAR(50), city VARCHAR(50) );
  
    delimiter //
    create procedure InsertOrders()
    begin
    INSERT INTO orders_table (id, name, city)
VALUES
(1, 'Rahul Sharma', 'Mumbai'),
(2, 'Priya Verma', 'Delhi'),
(3, 'Amit Kumar', 'Pune'),
(4, 'Sneha Patel', 'Ahmedabad'),
(5, 'Rohan Gupta', 'Bangalore');


end //
delimiter ;
call InsertOrders();
  select * from orders_table;

  drop procedure InsertOrders;
  truncate table  orders_table;