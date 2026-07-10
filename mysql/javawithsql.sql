use ankush_jdbc;
select * from employees;
desc employees;
select * from employees order by esal desc limit 3,4;
delimiter //
create procedure AddTwoNum(in num1 int,in num2 int,out result int)
begin
     set result = num1 + num2;
END //
delimiter ;
call getsalary(100,200,@result);   
select @result;     

delimiter //
create or replace procedure getsalary(in id int,out salary double(10,2))
begin
     select esal into salary from employees where eno = id;  
END //
delimiter ;
call getsalary(102,@salary);
select @salary;

select * from user;
create table user(email varchar(100),password varchar(100));
INSERT INTO user (email, password) VALUES 
('john.doe@example.com', 'hashed_pwd_9871'),
('sarah.smith@example.com', 'secure_pass_4321'),
('alex.jones@example.com', 'crypto_key_8899'),
('emma.watson@example.com', 'vault_pass_5566');

delimiter //
create or replace  procedure verification(in emails varchar(100),in passwords varchar(100),out flag boolean)
begin
     declare crosspass varchar(100);
     select password into crosspass from user where email = emails;
     if crosspass = passwords then
        set flag = true;
     else
        set flag = false;
     END if;   
END //
delimiter ;



