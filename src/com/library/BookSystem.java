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
		//bookDao.bookSelect();
		bookDao.showList();
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
		System.out.println("출판일 >> ");
		System.out.print("년 >> ");
		y = in.nextLine();
		System.out.print("월 >> ");
		m = in.nextLine();
		System.out.print("일 >> ");
		d = in.nextLine();
		pubDate = y+"-"+m+"-"+d;
		bookVo = new BookVo(title, author, pubs, pubDate);
		bookDao.bookInsert(bookVo);
		
		System.out.println("추가완료");
	}//BookCreat()
	
	public void bookUpdate() {
		System.out.println("<수정>");
		
		String[] update = new String[7];
		System.out.print("수정할 책 번호 입력 (건너뛰기:enter)>> ");
		bookId = in.nextInt();
		
		in.nextLine();
		System.out.print("책이름 >> ");
		update[0] = in.nextLine();
		System.out.print("작가 >> ");
		update[1] = in.nextLine();
		System.out.print("출판사 >> ");
		update[2] = in.nextLine();
		System.out.println("출판일 >> ");
		System.out.print("년 >> ");
		update[3] = in.nextLine();
		System.out.print("월 >> ");
		update[4] = in.nextLine();
		System.out.print("일 >> ");
		update[5] = in.nextLine();
		pubDate = update[3]+"-"+update[4]+"-"+update[5];
		for (int i = 0; i < update.length; i++) {
			switch (i) {
			case 0:
				if(update[i] == null) {
					update[i] = bookVo.getTitle();
				}
				break;
			case 1:
				if(update[i] == null) {
					update[i] = bookVo.getAuthor();
				}
				break;
			case 2:
				if(update[i] == null) {
					update[i] = bookVo.getPubs();
				}
				break;
			case 3:
				if(update[i] == null) {
					update[i] = bookVo.get;
				}
				break;
			case 4:
				break;
			case 5:
				break;
			}
		}
		bookVo = new BookVo(bookId, title, author, pubs, pubDate);
		bookDao.bookUpdate(bookVo);
	}//bookUpdate() 
	
	public void bookDelete() {
		System.out.println("<삭제>");
	}//bookDelete()
	
	
	
}
