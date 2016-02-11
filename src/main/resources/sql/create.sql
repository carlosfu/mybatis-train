create database football default character set utf8;
use football;

create table players(
id int primary key auto_increment,
name varchar(20) not null comment '名称',
age int comment '年龄'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='球员表';

insert into players(name,age) values('kaka',33);
insert into players(name,age) values('ronaldo',40);

CREATE TABLE club(  
id INT PRIMARY KEY AUTO_INCREMENT,  
name varchar(20) not null comment '俱乐部名称',   
info varchar(255) not null comment '俱乐部简介',  
create_date date comment '创建日期',  
rank smallint comment '排名'  
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='俱乐部表';  
INSERT INTO club(name, info, create_date, rank) VALUES('AC', 'AC米兰', '1899-12-26', 5);  
INSERT INTO club(name, info, create_date, rank) VALUES('Real Madrid', '皇家马德里', '1902-03-06', 1);  
INSERT INTO club(name, info, create_date, rank) VALUES('Inter', '国际米兰', '1908-03-09', 7);  

