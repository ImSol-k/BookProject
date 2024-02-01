

-- create database library_db
--   default character set utf8mb4
--     collate utf8mb4_general_ci
--     default encryption='n';
    

-- drop database library_db;
-- drop table librarys;
-- drop table members;
 drop table rents;

CREATE TABLE `librarys` (
	`book_id`	int	auto_increment	primary key,
	`title`	varchar(20)	NOT NULL,
	`author`	varchar(10),
	`pubs`	varchar(20),
	`pub_date`	date
);

CREATE TABLE `members` (
	`member_num`	int	auto_increment	primary key,
	`member_id`	varchar(20)	NOT NULL,
	`member_pw`	varchar(20)	NOT NULL,
<<<<<<< HEAD
	`meber_name`	varchar(30)	NOT NULL,
=======
	`member_name`	varchar(30)	NOT NULL,
>>>>>>> branch 'master' of https://github.com/ImSol-k/BookProject.git
	`ph`	varchar(20),
	`address`	varchar(30)
);

CREATE TABLE `rents` (
	`rent_id`	int	auto_increment	primary key,
	`member_num`	int,
	`book_id`	int,
	`rent_date`	date,
	`return_date`	date,
    constraint rents_bfk foreign key (book_id)
    references librarys (book_id),
    constraint rents_mfk foreign key (member_num)
    references members (member_num)
);
select 
from rents r
join book b
on r.book_id = b.book_id;


select * from members;
select * from rents;



insert into rents
values(null, (select member_num
		     from members
		     where member_id = 'asd'),
         
         2,date_format(now(),'%Y-%m-%d'),null);

insert into members
values (null,'qwe','qwe','박종희','010-888-888','주소');

update rents set return_date =  date_format(now(),'%Y-%m-%d')
where member_num = (select member_num
					from members
					where member_id = 'asd');

insert into members
values (null,'asd','asd','아무개','010-888-888','주소');

insert into members
values (null,'zxc','zxc','미아네','010-777-888','주소');

insert into librarys
values (null,'어린왕자','누군가','예림','2001-01-30');

insert into librarys
values (null,'메소드','그분','예랑','2011-02-10');

insert into librarys
values (null,'나집에갈래','누구','에잇','1991-11-20');



select *
from librarys;