package com.book;

public class AppTest {

	public static void main(String[] args) {

		BookDao bookDao = new BookDao();
		BookVo bookVo = new BookVo("한권으로 읽는 조선왕조실록", "박영규", "웅진", "1996-03-10", "대여중", "2024-01-10");

		
		//bookDao.bookInsert(bookVo);
		bookDao.bookSelect();
		bookDao.showList();

	}

}
 