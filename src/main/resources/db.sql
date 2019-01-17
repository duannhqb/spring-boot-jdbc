create database demo2

create table Hobby(
	id int primary key AUTO_INCREMENT,
    hobby nvarchar(50)
)

create table Student(
	id int primary key AUTO_INCREMENT,
    name nvarchar(50),
    hobby nvarchar(50), 
    email nvarchar(50), 
    phone nvarchar(50), 
    gender nvarchar(50),
    avatar nvarchar(250)
)