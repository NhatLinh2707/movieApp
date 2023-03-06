create database LoginDB
go
use LoginDB
go 
create table Users(
id int not null IDENTITY(1,1),
username varchar(255),
[password] varchar(255)
)
select * from Users 
where username = 'abc';