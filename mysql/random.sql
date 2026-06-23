use ankush;
select * from emp;
insert into emp(name,id) values("parth",101);   /*befor giving permission for insert*/
insert into emp(name,id) values("parth",101);   /*after giving permission for insert and select*/
select * from emp;
