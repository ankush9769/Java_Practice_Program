set autocommit = 0;
use ankush;
select * from emp;
start transaction;
insert into emp(name,id) values("yas",102);
savepoint sp1;
insert into emp(name,id) values("bisha",103);
savepoint sp2;
insert into emp(name,id) values("krishn",104);
savepoint sp3;
insert into emp(name,id) values("hell",105);


rollback to sp1;

