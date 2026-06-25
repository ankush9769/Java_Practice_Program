use ankush;
select * from emp;
/*why order by is expensive 
if the data set is huge then the problme are:
1) cpu
2) memory
3) temporary space

pagination = bringing the large dataset into small no. of record into a single page*/

create table custemers(cid int primary key,cname varchar(100));
create table orders(oid int primary key,oname varchar(100),cid int);
alter table orders add constraint f_key foreign key (cid) references custemers(cid);

INSERT INTO custemers (cid, cname) VALUES
(101, 'Alice Smith'),
(102, 'Bob Jones'),
(103, 'Charlie Brown'),
(104, 'Diana Prince'),
(105, 'Evan Wright');

INSERT INTO orders (oid, oname, cid) VALUES
(1, 'Laptop', 101),
(2, 'Smartphone', 102),
(3, 'Wireless Headphones', 101),
(4, 'Desk Chair', 103),
(5, 'Coffee Maker', 104),
(6, 'Mechanical Keyboard', 102),
(7, 'Monitor', 105),
(8, 'Gaming Mouse', 103),
(9, 'External Hard Drive', 101),
(10, 'Bookshelf', 104);

INSERT INTO custemers (cid, cname) VALUES  /*Customer who has not ordered anything */
(106, 'Frank Miller'),
(107, 'Grace Lee'),
(108, 'Henry Wilson');

ALTER TABLE orders 
ADD price DECIMAL(10, 2);
UPDATE orders SET price = 1200.00 WHERE oid = 1;  
UPDATE orders SET price = 799.99  WHERE oid = 2;  
UPDATE orders SET price = 149.50  WHERE oid = 3;  
UPDATE orders SET price = 210.00  WHERE oid = 4;  
UPDATE orders SET price = 89.99   WHERE oid = 5; 
UPDATE orders SET price = 125.00  WHERE oid = 6;  
UPDATE orders SET price = 299.99  WHERE oid = 7; 
UPDATE orders SET price = 65.00   WHERE oid = 8;  
UPDATE orders SET price = 110.00  WHERE oid = 9; 
UPDATE orders SET price = 185.50  WHERE oid = 10;

select * from custemers;
select * from orders;

/*Customer who has placed some order */
select c.cid,c.cname,o.oid,o.oname from custemers as c join orders as o on c.cid = o.cid;

/*left join*/
/*Customer who has not placed any order */
select c.cid,c.cname from custemers as c left join orders as o on c.cid = o.cid 
where o.oid is null;

/*who is manager of each emp(self join)*/

/*modern mysql often rewirter a subquery as a semi join which makes better performance and similar to joins */

/*problem with corelated subquery
find Find the customer whose price is greater than the average price. */
select * from custemers as c where price >(select avg(price) from orders as o where c.cid = o.cid);
/*Assume the customer table has a price field. */
/*It will run and calculate the average again and again and compare with the other records. */
/*Here the joint is the better option.*/

/*same problem for joine*/
select c.cid,avg(o.price) from custemers as c join orders as o on c.cid=o.cid group by c.cid;
/*single pass processing usually much faster*/

/*emp with greater than avg of dept salary*/
select * from emp  as e join dept as d on e.eid = d.eid where salary > (select avg(e.salary) from emp where e.did = d.did);
select * from emp as e where price > (select avg(e.salary) from emp);




/*difference betwen exists and joins*/
/*mysql 8.0 optimizer
many developer things joins are faster and subquery are slow which is not always true
mysql 8.0 optimizer can transform in , exists , subquery into optimize joine internally*/

select dname ,count(*) from dept group by dname;

/*view*/
create view custemer_view as
select oname,price from orders;

create view emp_view as
select name,id,salary from emp;
update emp_view set name='hell' where id=102;
-- drop view emp_view;
/*View-only can access the existing field of the table. */
/*If actual fields are not present in the table then it can't be accessible to the view. */
select * from emp;
select * from emp_view;

alter table emp add column salary decimal(10,2);
alter view emp_view as select name,id,salary from emp;/*altering the view */
insert into emp_view values('shreya',123,20000);
select * from custemer_view;
select ename,salary,(select avg(salary)from emp) as avg_salary from emp;/*subqurey in select clause*/
select * from (select dept,avg(salary) as avg_salary from emp group by dept)as derivedtable;/*subquery from cluase*/


/*temp table*/
create temporary table temptable(id int,name varchar(100));
desc temptable;
/*View stores query and temporary table stores entire data.*/

create or replace temporary table emp_temp
as
select id,name,salary from emp;

select  * from emp_temp;
insert into emp_temp values(122,'bhai',8989);
select * from emp;


create table sales(id int primary key auto_increment,city varchar(100));
INSERT INTO sales (city) VALUES 
('New York'),
('London'),
('Tokyo'),
('Paris'),
('Sydney'),
('Mumbai');
create temporary table sales_temp
as
select * from sales;
select * from sales_temp;
update sales_temp set city='york' where city='New York';
insert into sales(city) select city from sales_temp where city='york';  /*Add the changed temp table data into the original table. */


/*CTE common table expression */
with department_avg
as
(
 select dept,avg(salary) as avg_salary from emp group by department
)

-- cte are widly use in 
-- 1 reporting query
-- 2 ccomplex sql simplyfication
-- 3 recorsive queries 
-- 4 banking and ERP application 
-- cte is temporary name resultset that exist only duering execution of the query 

with dept_salary
as
(select department, AVG(salary) as avg_salary from emp group by department ) , high_salary as (select * from department, salary where avg_salary>60000 ));
select * from high_salary;

select * from emp;
-- UPDATE emp
-- SET salary =
--     CASE id
--         WHEN 101 THEN 50000
--         WHEN 102 THEN 55000
--         WHEN 103 THEN 60000
--         WHEN 104 THEN 65000
--         WHEN 105 THEN 70000
--     END;

select name,salary,row_number() over(order by salary desc) as salary_coloumn from emp;
select name,salary,dense_rank() over(order by salary desc) as salary_coloumn from emp;
select * from emp;

-- ALTER TABLE emp
-- ADD dept VARCHAR(20);
-- UPDATE emp
-- SET dept =
--     CASE id
--         WHEN 101 THEN 'HR'
--         WHEN 102 THEN 'IT'
--         WHEN 103 THEN 'Finance'
--         WHEN 104 THEN 'Sales'
--         WHEN 105 THEN 'Marketing'
--     END;

select name,salary,dept,row_number() over(partition by dept order by salary desc) as RN_dence from emp;

-- highest paid emp department wise
with highestsalary as( 
select name,salary,dept,row_number() over(partition by dept order by salary desc) as RN_dence from emp
)
select * from highestsalary where RN_dence=1;

-- Top three earners in each department.
-- find duplicate of the records (subquery with from clause)
select *,row_number() over(partition by dept order by id) as hello from emp where row_number>1;
-- windows function perform caluculation across related those without collapsing data .row_number gives unique number
-- rang() allows ties and skips rank , while dense_rank allows ties without skipping rank
-- these are basically use for ranking top an analysis ,duplication, reporting