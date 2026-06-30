use ankush;


CREATE TABLE departments (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL
);

CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    department_id INT,
    salary DECIMAL(10,2) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

CREATE TABLE performance_reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL,
    rating INT NOT NULL,
    review_date DATE,
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)  on delete cascade
);

CREATE TABLE employee_audit (
    audit_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    name VARCHAR(100),
    email VARCHAR(100),
    deleted_at DATETIME
);

CREATE TABLE employee_bonus (
    bonus_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    bonus_amount DECIMAL(10,2),
    created_at DATETIME,
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)  on delete cascade
);

CREATE TABLE error_logs (
    error_id INT AUTO_INCREMENT PRIMARY KEY,
    error_message TEXT,
    created_at DATETIME
);

-- 3
CREATE TABLE accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    account_holder VARCHAR(100) NOT NULL,
    balance DECIMAL(10,2) NOT NULL
);

CREATE TABLE transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    from_account INT,
    to_account INT,
    amount DECIMAL(10,2),
    transaction_date DATETIME DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    email VARCHAR(100)
);

CREATE TABLE orders2 (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    order_date DATETIME NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) DEFAULT 'PLACED',
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE orders_archive (
    order_id INT PRIMARY KEY,
    customer_id INT,
    order_date DATETIME,
    total_amount DECIMAL(10,2),
    status VARCHAR(20),
    archived_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE order_logs (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    log_message VARCHAR(255),
    created_at DATETIME,
    FOREIGN KEY (order_id) REFERENCES orders2(order_id)
);


CREATE TABLE categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL
);

CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    category_id INT,
    price DECIMAL(10,2) NOT NULL,
    stock_quantity INT DEFAULT 0,
    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

CREATE TABLE purchase_items (
    purchase_item_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    purchase_date DATE,
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

CREATE TABLE order_items (
    order_item_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders2(order_id) on delete cascade,
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);


CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255),
    status VARCHAR(20) NOT NULL
);

-- Departments
INSERT INTO departments (department_name) VALUES
('Engineering'),
('Human Resources'),
('Finance'),
('Sales'),
('Operations');

-- Employees
INSERT INTO employees (name, email, department_id, salary) VALUES
('Amit Sharma', 'amit.sharma@example.com', 1, 90000.00),
('Priya Mehta', 'priya.mehta@example.com', 1, 105000.00),
('Rahul Verma', 'rahul.verma@example.com', 2, 65000.00),
('Sneha Iyer', 'sneha.iyer@example.com', 3, 78000.00),
('Vikram Rao', 'vikram.rao@example.com', 4, 85000.00),
('Neha Singh', 'neha.singh@example.com', 5, 72000.00);

-- Performance Reviews
INSERT INTO performance_reviews (employee_id, rating, review_date) VALUES
(1, 4, '2026-01-15'),
(2, 5, '2026-01-15'),
(3, 3, '2026-01-16'),
(4, 4, '2026-01-17'),
(5, 5, '2026-01-18'),
(6, 2, '2026-01-19');

-- Accounts
INSERT INTO accounts (account_holder, balance) VALUES
('Amit Sharma', 50000.00),
('Priya Mehta', 30000.00),
('Rahul Verma', 15000.00);

-- Customers
INSERT INTO customers (customer_name, email) VALUES
('Acme Corp', 'billing@acme.com'),
('Globex Ltd', 'accounts@globex.com'),
('Initech', 'finance@initech.com'),
('Umbrella Pvt Ltd', 'orders@umbrella.com');

-- Categories
INSERT INTO categories (category_name) VALUES
('Electronics'),
('Furniture'),
('Stationery');

-- Products
INSERT INTO products (product_name, category_id, price, stock_quantity) VALUES
('Laptop', 1, 75000.00, 10),
('Mouse', 1, 700.00, 100),
('Office Chair', 2, 8500.00, 25),
('Desk', 2, 12000.00, 15),
('Notebook', 3, 80.00, 500),
('Pen', 3, 20.00, 1000);

-- Orders
INSERT INTO orders2 (customer_id, order_date, total_amount, status) VALUES
(1, '2026-01-10 10:30:00', 75700.00, 'PLACED'),
(2, '2026-02-12 14:20:00', 20500.00, 'PLACED'),
(3, '2026-03-18 09:10:00', 15000.00, 'PLACED'),
(4, '2025-11-05 16:45:00', 9000.00, 'PLACED'),
(1, '2025-12-20 11:00:00', 120000.00, 'PLACED');

-- Order Items
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES
(1, 1, 1, 75000.00),
(1, 2, 1, 700.00),
(2, 3, 1, 8500.00),
(2, 4, 1, 12000.00),
(3, 5, 100, 80.00),
(3, 6, 350, 20.00),
(4, 3, 1, 8500.00),
(4, 6, 25, 20.00),
(5, 1, 1, 75000.00),
(5, 4, 3, 12000.00),
(5, 2, 10, 700.00);

-- Purchase Items
INSERT INTO purchase_items (product_id, quantity, purchase_date) VALUES
(1, 20, '2026-01-01'),
(2, 200, '2026-01-01'),
(3, 40, '2026-01-02'),
(4, 25, '2026-01-02'),
(5, 800, '2026-01-03'),
(6, 1500, '2026-01-03');

-- Users
INSERT INTO users (email, password_hash, status) VALUES
('active.user@example.com', 'hashed_password_1', 'ACTIVE'),
('blocked.user@example.com', 'hashed_password_2', 'BLOCKED'),
('inactive.user@example.com', 'hashed_password_3', 'INACTIVE');

name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    department_id INT,
    salary DECIMAL(10,2) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
-- create New procedure for an email check.
delimiter // 
create procedure emailcheck(in names varchar(100),in dept varchar(100),in sal decimal(10,2),in emailid varchar(100))
begin
     if exists (select 1 from employees where email=emailid) then
        signal sqlstate '45000'
        set MESSAGE_TEXT = 'email already exist';
     else
		insert into employees(name,email,department_id,salary) values(names,emailid,dept,sal);
     END if;
END //     
delimiter ;
call emailcheck('yash','HR',34000,'rahul.verma@example.com');
select * from employees;




-- Check if the salary is negative or not. If salary is not negative then update successfully. 
delimiter //
create procedure salarycheck(in id int,in salaryy decimal(10,2))
begin
     if salaryy <=0 then
        signal sqlstate '45000'
        set message_text = 'salary is lesss than 0 or equal to 0';
     else
     update employees set salary = salaryy where employee_id=id;
     END if;
END //
delimiter ;     

call salarycheck(6,19999);
call salarycheck(6,-19999);





select * from accounts;

delimiter //
create or replace procedure transefer(in sender int , in receiver int,in amount decimal(10,2))
begin
     declare checkamount decimal(10,2);
     declare EXIT handler for SQLEXCEPTION
     begin
          rollback;
          resignal;
     END;
     start transaction;
     begin
     select balance into checkamount from accounts where account_id = sender;
     if amount > checkamount then
        signal sqlstate '45000'
        set message_text = 'Insufficient funds for transfer ';
     else  
         update accounts set balance = balance - amount where account_id = sender;
         update accounts set balance = balance + amount where account_id = receiver;
         insert into transactions(from_account,to_account,amount) values(sender,receiver,amount);
         commit;
     END if ;
     end ;
END //
delimiter ;     
select * from accounts;
  select * from transactions;   
  call transefer(1,2,10000);
  
  
  
  
  
  
  select * from employees;
  delimiter //
  create procedure showemp(in dept_id int)
  begin
       select name from employees where department_id = dept_id order by name desc;
  END //
  delimiter ;
  call showemp(1);
  
  
  
  delimiter //
  create or replace procedure search(in names varchar(100),in dept_id int,in min_sal decimal(10,2))
  begin 
       select * from employees 
       where (name = names OR name is null)
       OR(department_id is null OR department_id = dept_id)
       OR(salary is null OR salary>min_sal);
  END //
  delimiter ;
  call search(null,null,30000.00);
  call search('Amit Sharma',null,null);
  
  
  delimiter //
  create procedure deptdetails(in dept_id int)
  begin
       select count(*) as total_emp,sum(salary) as sum,avg(salary) as average,min(salary) as min ,max(salary) as max from employees where department_id = dept_id group by dept_id;
  END //
  delimiter ;
  call deptdetails(1);
  
--   dept name bhi ana chahiye





select * from employee_audit;
delimiter //
create procedure addanddelete(in emp_id int)
begin
     insert into employee_audit(employee_id,name,email) values(emp_id,(select name from employees where employee_id = emp_id),(select email from employees where employee_id = emp_id));
      delete from employees where employee_id = emp_id;
END //
delimiter ; 
call addanddelete(2);  






select * from performance_reviews  
delimiter //
create or replace procedure performance_inc(in rate int,in increment decimal(10,2))
begin
     update employees as e join performance_reviews as pr on e.employee_id = pr.employee_id set e.salary = e.salary + (e.salary*increment) where pr.rating >= rate;
END //
delimiter ;
call performance_inc();

use ankush;
select * from orders2;
-- problem statment
-- we have orders2 table
-- generat monthly sales report
-- month wise no. of item sold and sum of the total amount..........  arg(year)


-- delimiter //
-- create procedure sale(in year int)
-- begin
--      select count(id) as total_order,sum(total_amount) as total_sales 
--      from orders2 where year(order_date)year group by month_of_order_date;
-- END //
-- delimiter ;

select * from orders2;
delimiter //
create procedure monthly_sal(In O_year year)
begin
SELECT
    MONTH(order_date) AS month,
    COUNT(order_id) AS total_orders,
    SUM(total_amount) AS total_sales
FROM orders2
WHERE YEAR(order_date) = O_year
GROUP BY MONTH(order_date)
ORDER BY MONTH(order_date);
end //
delimiter ;
call monthly_sal(2026);



select * from orders2;
select * from customers;
delimiter //
create or replace procedure topsalecustomer(in limits int)
begin
     select c.customer_id,c.customer_name,sum(o.total_amount) as total_sum_amount
     from customers as c join orders2 as o on c.customer_id = o.customer_id
     group by customer_id order by total_sum_amount desc limit limits;
END //     
delimiter ;

call topsalecustomer(3);



select * from products;
delimiter //
create procedure c_price_incre(in c_id int,in incr decimal(10,2))
begin
     update products set price = price + (price*incr) where category_id = c_id;
END //
delimiter ;

call c_price_incre(1,0.1);



select * from orders2;
select * from order_logs;
delimiter //
create procedure orderplace1(in c_id int,in amount decimal(10,2))
begin

     declare exit handler for sqlexception
     begin
          rollback;
          resignal;
     END;
     start transaction;
     begin
     declare last_orderid int;
     insert into orders2(customer_id,order_date,total_amount,status) 
     values(c_id,now(),amount,'PLACED');
     set last_orderid = last_insert_id();
     
     insert into order_logs(order_id,log_message,created_at)
     values(last_orderid,'order placed successfull',now());
     commit;
     end;
END //     
delimiter ;
call orderplace1(2,5000);




-- Problem statement 1. 
-- Cancel Order and Restock Order (orders2,order_items ,products)


-- Problem statement 2.
-- Delete the records from the main table before 20th Jan. 
-- And take a log in an order archive. 
select * from orders_archive;
select * from orders2;
set sql_safe_updates=0;
delimiter //
create or replace procedure deleteandinsert(in dates date)
begin
     declare exit handler for sqlexception
     begin
         rollback;
         resignal;
     end;
     start transaction;
     begin
     insert into orders_archive(order_id,customer_id,order_date,total_amount,status)
      select order_id,customer_id,order_date,total_amount,status from orders2 where order_date < dates;
      
      delete from orders2 where order_date < dates;
      commit;
      end;
      
END //
delimiter ;
call deleteandinsert('2026-11-02');




select * from users;
delimiter //
create procedure logincheck(in emailcheck varchar(100))
begin
     select user_id,email,status,
     case 
         when status = 'active' then 'login allowed'
         else 'login block'
     END as login_status 
     from users where email = emailcheck;
END //
delimiter ;

call logincheck('active.user@example.com');
call logincheck('blocked.user@example.com');




select * from employees;
delimiter //
create procedure getsalary(in eid int ,out sal decimal(10,2))
begin
     select salary into sal from employees where employee_id = eid;
END //
delimiter ;  
call getsalary(1,@sal);   
select @sal;


-- Ifnull-functional. 



-- Problem statement 
-- in d_id,
-- out d wise total salary,avg(salary),max,min salary 
-- if If any of them are null then replace with zero. 
select * from departments;
select * from employees;
delimiter //
create or replace procedure dept_wisesal_statics(
in dept_id int ,out totalsal decimal(10,2),out avgsal decimal(10,2),out maxsal decimal(10,2),out minsal decimal(10,2))
begin
     select ifnull(sum(salary),0),
     ifnull(avg(salary),0),
     ifnull(max(salary),0),
     ifnull(min(salary),0) into totalsal,avgsal,maxsal,minsal from employees where department_id = dept_id;
END //
delimiter ;

call dept_wisesal_statics(1,@totalsal,@avgsal,@maxsal,@minsal);
select @totalsal,@avgsal,@maxsal,@minsal;
     
     
     
select * from employees;
delimiter //
create or replace procedure addemp(
in ename varchar(100),
in eemail varchar(100),
in dept_id int,
in sal decimal(10,2),
out lastid int)
begin
     insert into employees(name,email,department_id,salary)
     values(ename,eemail,dept_id,sal);
     set lastid = last_insert_id();
END //
delimiter ;    

call addemp('yashu','yash@gmail.com',1,23000,@lastid); 
select @lastid;






-- INOUT parameter
delimiter //
create or replace procedure discount(in dis decimal(10,2),inout amount decimal(10,2))
begin
    set amount = amount - (amount * dis);
END //
delimiter ;

set @amount = 10000;
call discount(0.1,@amount);
select @amount;




delimiter //
create or replace procedure stringoperation(inout pname varchar(100))
begin
     set pname = trim(pname);
     set pname = concat(upper(left(pname,1)),lower(substring(pname,2)));
END //
delimiter ;
set @pname = '  ankush pal ';
call stringoperation(@pname);
select @pname;




-- pagination
delimiter //
create or replace procedure pagination(in current_page int,in total_record int)
begin
     declare start int;
     declare end int;
     set start =((current_page-1) * total_record)+1;
     set end = (current_page) * total_record;
     select start,end;
END //
delimiter ;
     
call pagination(3,10);




delimiter //
create or replace procedure atm(in max_retry int,inout retry_count int,inout status varchar(100))
begin
set retry_count = retry_count + 1;
     if max_retry>retry_count then
        set status = 'allowed';
     else set status = 'not allowed';  
     END if;
END //
delimiter ;

set @retry=1;
call atm(5,@retry,@status);
select @retry;
select @status;


set @sequence = 100
genrateinvoice("inv",@sequence,@invoicno)
eg..    inv-2026-00100
    inv-2026-00101