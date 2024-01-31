package com.library;

import java.util.Scanner;

public class AppTest {

	public static void main(String[] args) {

		BookVo bookVo2 = new BookVo("세이노의 가르침", "세이노", "데이원");

		//bookDao.bookInsert(bookVo2);
		//bookDao.bookSelect();
		//bookDao.showList();
		
		Scanner in = new Scanner(System.in);
		BookDao bookDao = new BookDao();
		BookSystem bookSys = new BookSystem();
		boolean start = true;
		int num;
		try {
			while(start) {
				
				System.out.println("========================================");
				System.out.println("<책관리>");
				System.out.println("1.리스트 2.추가 3.수정 4.삭제 5.돌아가기 6.종료");
				System.out.print(">> ");
				num = in.nextInt();
				in.nextLine();
				System.out.println("========================================");
				
				switch(num) {
				case 1:
					bookSys.bookList();
					start = true;
					break;
				case 2:
					bookSys.bookCreat();
					start = true;
					break;
				case 3:
					bookSys.bookList();
					bookSys.bookUpdate();
					start = true;
					break;
				case 4:
					bookSys.bookDelete();
					start = true;
					break;
				case 5:
					System.out.println("<돌아가기>");
					start = true;
					break;
				case 6:
					System.out.println("<프로그램 종료>");
					start = false;
					break;
				default:
					System.out.println("잘못입력하셨습니다");
					start = true;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("알 수 없는 숫자");
		}
		
			
			
		
	}
	

}
