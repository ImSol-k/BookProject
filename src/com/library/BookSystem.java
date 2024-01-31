package com.library;

import java.util.Scanner;

public class BookSystem {
	
	Scanner in = new Scanner(System.in);
	BookDao bookDao = new BookDao();
	BookVo bookVo;
	private String title, author, pubs, pubDate;
	
	//책 리스트 출력함수
	public void bookList() {
		System.out.println("<리스트>");
		bookDao.bookList();
	}
	
	//책 추가함수
	public void bookCreat() {
		
		System.out.println("<책등록>");
		System.out.print("책이름 >> ");
		title = in.nextLine();
		System.out.print("작가 >> ");
		author = in.nextLine();
		System.out.print("출판사 >> ");
		pubs = in.nextLine();
		System.out.print("출판일 >> ");
		pubDate = in.nextLine();
		bookVo = new BookVo(title, author, pubs, pubDate);
		bookDao.bookInsert(bookVo);
		
		System.out.println("추가완료");
	}
	

}
