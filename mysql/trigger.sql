use ankush;
-- trigger
-- a trigger is a special database object that automaticaly executes when a specified event occurs in a table
-- trigger will be applied on DML commands
-- insert before update
-- insert before delete
-- insert after update
-- insert after delete

-- in mysql triggers provides special sudo records
-- old -> existing values before update and delete operation
-- new -> new rows value for insert and update


-- Before inserting the value, give me the error if it provides the negative value. 
delimiter //
create trigger beforeinsert
before insert
on emp
for each row
begin
     if(new.salary<0) then
        SIGNAL SQLSTATE '45000'
        set message_text = "salary can not be negative";
     END if;
END //
delimiter ;
select * from emp;
insert into emp(name,id,salary,dept) values
('shubham','109',-45000,'HR');


-- Okay so first we are creating a table and then entering the new value.
-- Basically we are auditing a new employee who is entering here. 

create table emp_log(audit_id int primary key auto_increment,action_type varchar(100),emp_id int,action_time datetime); 
	
delimiter //    
create trigger afteremplog
after insert on emp
for each row
begin
     insert into emp_log(action_type,emp_id,action_time) values
	('insert',new.id,now());
END //    
delimiter ;

insert into emp(name,id,salary,dept) values
('shashi','110',45000,'HR');
select * from emp_log;




delimiter //
create trigger salupdatebefore
before update on emp
for each row
begin
    if new.salary<(old.salary*0.5) then
       SIGNAL sqlstate '45000'
       set message_text = "new salary is less than 50% of origin salary so no changes";
	END if;
END //
delimiter ;    
select * from emp;
update emp set salary = 20000 where id=101;  -- will give error
update emp set salary = 30000 where id=101;



create table salary_log(id int , old_salary decimal(10,2),new_salary decimal(10,2));
delimiter //
create or replace trigger salary_log
after update on emp
for each row
begin 
     if old.salary <> new.salary then    -- not equal sign = <>
        insert into salary_log(id,old_salary,new_salary) values
        (old.id,old.salary,new.salary);
     END if;
END //
delimiter ;  
select * from emp;
update emp set salary = 30000 where id = 101;  
select * from salary_log;




delimiter //
create or replace trigger deleteEmp
before delete 
on emp
for each row 
begin
if old.id=1 then
signal sqlstate  '45000'
set message_text = 'ceo will not be removed ';
end if ;
end //
delimiter ;
delete from emp where id =1;
insert into emp values(1,'test2',5666,'hr');
update emp set salary = 60000 where id=8;
update emp set salary =60000 where id =8;
  
  
  
  
  
  create table deleteHistory(id int , name varchar(50), deleted_on datetime);
delimiter //
create or replace trigger deleteLog
after delete
on emp
for each row 
begin 
   insert into deleteHistory values(old.id, old.name, now());
end //
delimiter ;
delete from emp where id =12;
 select * from deleteHistory;
