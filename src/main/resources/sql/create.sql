create database football default character set utf8;
use football;

create table players(
id int primary key auto_increment,
name varchar(20) not null comment '名称',
age int comment '年龄'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='球员表';

insert into players(name,age) values('kaka',33);
insert into players(name,age) values('ronaldo',40);