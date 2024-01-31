
create database library_db
  default character set utf8mb4
    collate utf8mb4_general_ci
    default encryption='n';
    

drop database library_db;
drop table librarys;
drop table members;
drop table rents;

show tables;

CREATE TABLE `librarys` (
	`book_id`	int	NOT NULL,
	`rent`	varchar(10)	NOT NULL,
	`title`	varchar(20)	NOT NULL,
	`author`	varchar(10)	NULL,
	`pubs`	varchar(20)	NULL,
	`pub_date`	date	NULL
);

CREATE TABLE `members` (
	`member_num`	int	NOT NULL,
	`book_id`	int	NOT NULL,
	`rent`	varchar(10)	NOT NULL,
	`member_id`	varchar(20)	NOT NULL,
	`member_pw`	varchar(20)	NOT NULL,
	`name`	varchar(30)	NOT NULL,
	`ph`	varchar(20)	NULL,
	`address`	varchar(30)	NULL
);

CREATE TABLE `rents` (
	`rent`	varchar(10)	NOT NULL,
	`book_id`	int	NOT NULL,
	`member_num`	int	NOT NULL,
	`rent_date`	date	NULL
);

ALTER TABLE `librarys` ADD CONSTRAINT `PK_LIBRARYS` PRIMARY KEY (
	`book_id`,
	`rent`
);

ALTER TABLE `members` ADD CONSTRAINT `PK_MEMBERS` PRIMARY KEY (
	`member_num`,
	`book_id`,
	`rent`
);

ALTER TABLE `rents` ADD CONSTRAINT `PK_RENTS` PRIMARY KEY (
	`rent`,
	`book_id`
);

ALTER TABLE `librarys` ADD CONSTRAINT `FK_rents_TO_librarys_1` FOREIGN KEY (
	`rent`
)
REFERENCES `rents` (
	`rent`
);

ALTER TABLE `members` ADD CONSTRAINT `FK_librarys_TO_members_1` FOREIGN KEY (
	`book_id`
)
REFERENCES `librarys` (
	`book_id`
);

ALTER TABLE `members` ADD CONSTRAINT `FK_librarys_TO_members_2` FOREIGN KEY (
	`rent`
)
REFERENCES `librarys` (
	`rent`
);

ALTER TABLE `rents` ADD CONSTRAINT `FK_librarys_TO_rents_1` FOREIGN KEY (
	`book_id`
)
REFERENCES `librarys` (
	`book_id`
);

ALTER TABLE `rents` ADD CONSTRAINT `FK_members_TO_rents_1` FOREIGN KEY (
	`member_num`
)
REFERENCES `members` (
	`member_num`
);




