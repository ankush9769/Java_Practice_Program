show databases;
create database ankush;
/*create 'user'*/ 
create user 'ankush'@'%' identified by 'ankush1234';
use ankush;
create table emp(name varchar(100),id int);
grant select on ankush.emp to 'ankush'@'%'; /* giving the permission to selelct only*/
grant select,insert on ankush.emp to 'ankush'@'%';
/*this user can only login to in your application is running a script for terminal directly on the same physical server whrer mysql is install*/

create user 'reportankush'@'192.168.105.10' identified by 'ankush1234';
/*the user can only login from that specific internet ip address which on 192.168.105.10*/

create user 'parth'@'%' identified by 'ankush1234';

/* assume 'parth'@'%'*/
grant all privileges on ankush.emp to 'parth'@'%';


/*with grant oprion     */
grant all privileges on *.* to 'parth'@'%' with grant option;
/* it has access of every thing
can grant permissino to others user 
here parth can give the access to other user*/


/*revoke the permission from the user*/   
revoke insert on ankush.emp from 'ankush'@'%';

/*drop the user's */
drop user 'ankush'@'%';

/*what persimmision the perticular use has*/
show grants for 'ankush'@'%';



/*RBAC role base access control*/
create role managererole; /* creating roel*/
grant select on ankush.emp to managererole;  /* giving access to role*/
grant managererole to 'ankush'@'%';  /*assinging the role to the user ankush*/
grant managererole to 'ankush'@'%','parth'@'%'; /*multiple user*/






