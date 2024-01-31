

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
	`name`	varchar(30)	NOT NULL,
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

select *
from members;

-- 회원등록
insert into members 
  value(null,'diony','1234','오지원','010-4765-0429','서울');
  insert into members 
  value(null,'apple','1234','오지원','010-4765-0429','서울');
  insert into members 
  value(null,'5g1','1234','오지원','010-4765-0429','서울');
  insert into members 
  value(null,'5G1','1234','오지원','010-4765-0429','서울');
  
-- 로그인  
insert into members 
  value(null,?,?,?,?,?);

select member_id, 
         member_pw
  from members 
  where member_id in (2,3);
  
select member_id, 
	   member_pw
from Login 
where member_id in (2,2);

-- 작가수정
update author 
set author_name = '기안84', 
    author_desc = '웹툰작가'
where author_id = 3;
-- 회원수정
update members
set  member_pw =123, 
     name = '오지원' ,
     hp = '010-0000-1111' ,
     address = '안산' 
where member_id = 'ggg';