package com.library;

public class AppTest {

	public static void main(String[] args) {

		BookDao bookDao = new BookDao();
		BookVo bookVo1 = new BookVo("퍼스트자바", "자바");
		BookVo bookVo2 = new BookVo("세이노의 가르침", "세이노", "데이원");

		bookDao.bookInsert(bookVo2);
		bookDao.bookSelect();
		bookDao.showList();

	}

}
