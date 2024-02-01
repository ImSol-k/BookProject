package com.library;

import java.util.Scanner;

public class ManagerApp {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		BookManager bookM = new BookManager();
		RentManager rentM = new RentManager();
		MemberDao memberDao = new MemberDao();
		boolean start = true;
		int num;
		
		
		System.out.println("<도서대여 관리 프로그램>");
		System.out.println("<관리자>");
		
		EXIT : while(start) {
			System.out.println("==============================================================================");
			System.out.println("1.대여관리 2.회원리스트 3.책관리 4.종료");
			System.out.print(">> ");
			num = in.nextInt();
			in.nextLine();
			int result;
			switch(num) {
			case 1:
				rentM.rentManagement();
				result = rentM.rentManagement();
				if(result == 0) {
					start = false;
				}else if(result == -1) {
					start = true;
				}
				break;
			case 2:
				memberDao.memberList();
				start = true;
				break;
			case 3:
				result = bookM.bookManager();
				// 0종료 -1돌아가기  1정상
				if(result == 0) {
					start = false;
				}else if(result == -1) {
					start = true;
				}
				break;
			case 4:
				start = false;
				break EXIT;
			}		
			
			
		}
		System.out.println("<프로그램 종료>");
		in.close();
	}

}
