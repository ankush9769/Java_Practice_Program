
use ankush;
create table emps(id int,name varchar(100),dept varchar(100),salary decimal(10,2),city varchar(100),doj date)
INSERT INTO emps (id, name, dept, salary, city, doj) VALUES
(1, 'Amit Sharma', 'IT', 85000.00, 'Mumbai', '2024-03-15'),
(2, 'Priya Patel', 'HR', 62000.50, 'Ahmedabad', '2025-01-10'),
(3, 'Rohan Das', 'Finance', 78000.00, 'Kolkata', '2023-11-22'),
(4, 'Sneha Reddy', 'Marketing', 69500.00, 'Hyderabad', '2025-05-02'),
(5, 'Vikram Malhotra', 'Operations', 54000.75, 'Delhi', '2026-02-18');


/*select all emp where id =1*/
select * from emps where id = 1;

/**/
select * from emps where salary>70000 and city="kolkata";
select * from emps where city in ('Delhi','kolkata');
select * from emps where salary between 500000.0 and 700000.00;
select * from emps where name like '%Das';





select * from transaction where status='success' and amount>1000000;
select * from coustomer as c where exists(select 1 from order as o where o.customeid = c.customerid);
/* for large corelated data set 'exists' often performs better becouase it stops searching once the matches found while 
'in' compare and return all the data*/
/*in compare values and exists check existence of the row*/
/*exist is often better for large dataset with coorelated subquery*/
/*  %gmail = what is problem with this comamand:
1)leading wildcard prevent index usage,
2)full table scan may occur
3)query becomes slow  */


/*string method*/
select concat_ws(name,id,dept) from emps;
select substr(name,1,4) from emps;
select replace('he','ll',name);

/*date function */
select curdate();
select now();
select year(doj) from emps;
select month(doj) from emps;
select day(doj) from emps;
select datediff(curdate(),doj);
/* interval as keyword which is represent a time period(days,months,hrs)that can be added to or subtractedd from a data time values*/
select current_date()+interval 7 day;
select date_add(current_date(),interval 10 day);
select date_sub(current_date(),interval 7 day);
/*timestampdiff its a date time function used to calculated difference between two dates ro timestamps in a specified unit */

/*dept it salray>50000 comming form mumbai or pune join in 2025*/
