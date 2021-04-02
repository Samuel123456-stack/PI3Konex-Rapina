drop database bd_test_rapina;

create database bd_test_rapina;
use bd_test_rapina;

create table tbreserva(
idRes int auto_increment primary key,
nomeCli varchar(45) not null,
dataRes datetime,
statusRes boolean
);



insert into tbreserva (nomeCli,dataRes,statusRes) values('Arnaldo Soares','2021-03-28 11:45',false),('Rosimeire Silva','2021-03-28 11:45',true),('Caio Santos','2021-03-28 11:45',true),('Caio Santosaaaaaaaaaaaaa','2021-03-28 11:45',true);


select * from tbreserva;
select *, DATE_FORMAT(dataRes, '%d/%m/%Y  %H:%i') from tbreserva; 

