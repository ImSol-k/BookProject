package com.library;

import java.util.Scanner;

public class BookManager {

	public int bookManager() {

		//bookDao.bookInsert(bookVo2);
		//bookDao.bookSelect();
		//bookDao.showList();
		
		Scanner in = new Scanner(System.in);
		BookSystem bookSys = new BookSystem();
		String line = "==============================================================================";
		boolean start = true;
		int num;
		
		try {
			while(start) {
				
				System.out.println(line);
				System.out.println("<책관리>");
				System.out.println("1.리스트 2.추가 3.수정 4.삭제 5.검색 6.돌아가기 7.종료");
				System.out.print(">> ");
				num = in.nextInt();
				in.nextLine();
				System.out.println(line);
				
				switch(num) {
				case 1:
					System.out.println(line);
					bookSys.bookList();
					start = true;
					break;
				case 2:
					System.out.println(line);
					bookSys.bookCreat();
					start = true;
					break; 
				case 3:
					bookSys.bookList();
					System.out.println(line);
					bookSys.bookUpdate();
					start = true;
					break;
				case 4:
					System.out.println(line);
					bookSys.bookDelete();
					start = true;
					break;
				case 5:
					System.out.println(line);
					bookSys.bookSearch();
					start = true;
					break;
				case 6:
					System.out.println(line);
					System.out.println("<돌아가기>");
					start = false;
					return -1;
					
				case 7:
					System.out.println(line);
					//System.out.println("<프로그램 종료>");
					start = false;
					return 0;
				default:
					System.out.println("잘못입력하셨습니다");
					start = true;
					break;
				}
		}
		} catch (Exception e) {
			System.out.println("알 수 없는 숫자");
		}
		
			
		in.close();
		return 1;
	}//main
	

}
