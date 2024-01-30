
create database library_db
  default character set utf8mb4
    collate utf8mb4_general_ci
    default encryption='n';

show databases;
show tables;

drop table library;
drop table member;

create table member(
	member_id	int			auto_increment	primary key,
    member_pw	varchar(30) not null,
    member_name varchar(30) not null,
    ph varchar(30),
    address varchar(30)
    );

create table library(
	book_id	int			auto_increment	primary key,
    title	varchar(30) not null,
    author_name varchar(30),
    pubs varchar(30),
    pub_date varchar(30),
    rent varchar(10),
    rent_date date,
    member_id int,
    constraint library_fk foreign key (member_id)
    references member (member_id)
    );
    
insert into library values (null, 'firstJAVA', '유영진', 'YD', '2024-01-01', '대여가능', '2024-01-30', null);
select * from library;
select * from member;
    
update library 
   set title = '조선왕조실록',
	   author_name = '박영규',
	   pubs = '웅진',
	   pub_date = null,
	   rent = '대여가능',
 	   rent_date = null,
 	   member_id = null
 where book_id = 3;
show tables;update book     set title = '조선왕조실록',     author_name = '박영규',     pubs = '웅진',     pub_date = null,     rent = '대여가능',      rent_date = null,      member_id = null  where book_id = 3
update book     set title = '조선왕조실록',     author_name = '박영규',     pubs = '웅진',     pub_date = null,     rent = '대여가능',      rent_date = null,      member_id = null  where book_id = 3
