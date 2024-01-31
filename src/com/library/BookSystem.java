package com.library;

import java.util.Scanner;

public class BookSystem {

	private Scanner in = new Scanner(System.in);
	private BookDao bookDao = new BookDao();
	private BookVo bookVo;
	private int bookId;
	private String title, author, pubs, pubDate;
	
	
	/************************************
	 * 책 리스트 출력함수 *
	 * **********************************/
	public void bookList() {
		System.out.println("<리스트>");
		bookDao.bookSelect();

	}// bookList()

	
	/************************************
	 * 책 추가함수	*
	 * **********************************/
	public void bookCreat() {

		bookVo = new BookVo();

		System.out.println("<책등록>");
		System.out.print("책이름 >> ");
		bookVo.setTitle(in.nextLine());
		System.out.print("작가 >> ");
		bookVo.setAuthor(in.nextLine());
		System.out.print("출판사 >> ");
		bookVo.setPubs(in.nextLine());
		System.out.print("출판일 >> ");
		bookVo.setPubDate(in.nextLine());

		bookVo = new BookVo(title, author, pubs, pubDate);
		bookDao.bookInsert(bookVo);

		System.out.println("추가완료");
	}// BookCreat()

	
	/************************************
	 * 책 수정함수	*
	 * **********************************/
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

		// System.out.println(bookVo);

		bookDao.bookUpdate(bookVo);
		// System.out.println(bookVo.getTitle() + " " + bookVo.getAuthor() + " " +
		// bookVo.getPubs() + " " + bookVo.getPubDate());
	}// bookUpdate()

	
	/************************************
	 * 책 삭제함수 *
	 * **********************************/
	public void bookDelete() {
		System.out.println("<삭제>");
		bookVo = new BookVo();

		System.out.print("삭제할 책번호 입력 >>");
		bookVo.setBookId(in.nextInt());
		bookDao.bookDelete(bookVo.getBookId());

	}// bookDelete()

	
	/************************************
	 * 책 검색함수 *
	 * **********************************/
	public void bookSearch() {
		
		int num;
		boolean start = true;
		while (start) {
			System.out.println("<검색 타입 선택>");
			System.out.println("1.제목 2.작가 3.번호 4.뒤로가기");
			num = in.nextInt();
			in.nextLine();
			switch (num) {
			case 1:
				findTitle();
				break;
			case 2:
				findAuthor();
				break;
			case 3:
				findId();
				break;
			case 4:
				start = false;
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}//switch
		}//while
	}//bookSearch();

	public void findTitle() {
		System.out.print("제목검색 >> ");
		title = in.nextLine();
	}

	public void findAuthor() {
		System.out.print("작가검색 >> ");
		author = in.nextLine();
	}

	public void findId() {
		System.out.print("번호검색 >> ");
		bookId = in.nextInt();
	}

}
