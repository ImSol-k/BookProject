package com.library;

import java.util.Scanner;

public class BookSystem {
	
	Scanner in = new Scanner(System.in);
	BookDao bookDao = new BookDao();
	BookVo bookVo;
	private int bookId;
	private String title, author, pubs, y, m, d, pubDate;
	

	//책 리스트 출력함수
	public void bookList() {
		System.out.println("<리스트>");
		bookDao.bookSelect();
	}//bookList()
	
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
	}//BookCreat()
	
	public void bookUpdate() {
		System.out.println("<수정>");
		
		bookVo = new BookVo();
		
		System.out.print("수정할 책 번호 입력 (건너뛰기:enter)>> ");
		bookVo.setBookId(in.nextInt());
		
		in.nextLine();
		System.out.print("책이름 >> ");
		bookVo.setTitle(in.nextLine());
		System.out.print("작가 >> ");
		bookVo.setAuthor(in.nextLine());
		System.out.print("출판사 >> ");
		bookVo.setPubs(in.nextLine());
		System.out.print("출판일 >> ");
		bookVo.setPubDate(in.nextLine());
	
		System.out.println(bookVo);
		
		
		bookDao.bookUpdate(bookVo);
		//System.out.println(bookVo.getTitle() + " " + bookVo.getAuthor() + " " + bookVo.getPubs() + " " + bookVo.getPubDate());
	}//bookUpdate() 
	
	public void bookDelete() {
		System.out.println("<삭제>");
		
	}//bookDelete()
	
	
	
}
