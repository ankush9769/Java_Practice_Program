create database bankingsystem;
use bankingsystem;
create table user(id int auto_increment primary key,name varchar(100),email varchar(100),accountno int,ifsc varchar(100),branch varchar(100),role VARCHAR(20) NOT NULL DEFAULT 'user',balance decimal(10,2));
create table transaction(id int auto_increment primary key,userid int ,type enum('WITHDRAW','DEPOSIT'),
amount decimal(10,2),balanceafter decimal(10,2),status enum('TRANSFERRED','SUCCESSFUL','CANCELLED','FAILED'),
reason varchar(100),time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
foreign key(userid) references user(id));

alter table user add column password varchar(100);

insert into user(name,email,role) value('admin','admin@gmail.com','admin');
select * from user where role = 'admin';
show databases;
desc user;
select * from user;
update user set password = 'ad3305807bf135826421983486ee45d0fb3733edafa364c383da9c0618026f99' where name = 'admin';
update user set balance =balance+10000 where id = 2;
commit;
set autocommit = 1;