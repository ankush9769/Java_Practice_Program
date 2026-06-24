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


/*CTE common table expression */
with department_avg
as
(
 select dept,avg(salary) as avg_salary from emp group by department
)

/*difference betwen exists and joins*/
/*mysql 8.0 optimizer
many developer things joins are faster and subquery are slow which is not always true
mysql 8.0 optimizer can transform in , exists , subquery into optimize joine internally*/

select dname ,count(*) from dept group by dname;

/*view*/
create view custemer_view as
select oname,price from orders;

select * from custemer_view;
select ename,salary,(select avg(salary)from emp) as avg_salary from emp;/*subqurey in select cluose*/
select * from (select dept,avg(salary) as avg_salary from emp group by dept)as derivedtable;/*subquery from cluase*/

