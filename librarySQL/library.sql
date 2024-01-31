



drop table librarys;
drop table members;
drop table rents;
    
  

select * from librarys;
select * from members;
    
update library 
   set title = '조선왕조실록',
	   author_name = '박영규',
	   pubs = '웅진',
	   pub_date = null,
 	   member_id = null
 where book_id = 3;
