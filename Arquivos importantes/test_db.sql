drop database bd_test_rapina;

create database bd_test_rapina;
use bd_test_rapina;

create table tbreserva(
idRes int auto_increment primary key,
nomeCli varchar(45) not null,
dataRes datetime,
statusRes boolean
);



insert into tbreserva (nomeCli,dataRes,statusRes) values('Resident Evil','2015-11-05 14:54',false);


select * from tbreserva;
select DATE_FORMAT(dataRes, '%d/%m/%Y  %H:%i') from tbreserva;

