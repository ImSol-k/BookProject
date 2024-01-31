

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
