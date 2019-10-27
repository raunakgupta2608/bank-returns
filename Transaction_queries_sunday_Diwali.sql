select * from customerdetails01;

select * from admin01;

select * from REGISTERIB01;

select * from BENEFICIARYDETAILS01;

select * from TRANSACTION01;

select AVAILABLEBALANCE from Transaction01 where tid = ( select max(tid) from Transaction01 where refuserid=81) 

select max(tid)-1 from Transaction01 where refuserid=81

truncate table TRANSACTION01;

drop sequence TRANSACTIONID;

select t.availablebalance from Transaction01 t where t.tid = ( select max(t.tid)-1 from Transaction01 t where t.refuserid=:userid)

insert into Transaction01 values(2, 81, 84, 10000, 400, 'adv', '27-10-19' , '01-01-70', 9400 );
delete from Transaction01 where BALANCE =0;












truncate table BENEFICIARYDETAILS01;

truncate table transaction01;


create table transaction01(
tid number(5) primary key,
refuserid varchar2(25),    
refbeneficiaryaccno number(4),
balance number(10) default 10000,
transactionamt number(10),
toname varchar2(25),
transactiondate varchar2(20),
transactiontime varchar2(20)
);
drop table transaction01; 





