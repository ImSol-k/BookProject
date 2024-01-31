package com.library;

public class AppTest {

	public static void main(String[] args) {

		BookDao bookDao = new BookDao();
		BookVo bookVo = new BookVo("한권으로 읽는 조선왕조실록", "박영규", "웅진", "1996-03-10");

		BookVo bookVo1 = new BookVo(3,"한권 조선왕조실록", "박영규", "웅진(지식하우스)", "1996-03-10");
		//bookDao.bookUpdate(bookVo1);
		bookDao.bookInsert(bookVo);
		bookDao.bookSelect();
		bookDao.showList();
		// bookDao.bookDelete(2);
		// bookDao.showList();
		
	}

}
