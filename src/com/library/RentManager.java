package com.library;

import java.util.Scanner;

public class RentManager {
	
	RentDao rentDao =new RentDao();
	MemberVo memberVo = new MemberVo();

	Scanner sc = new Scanner(System.in);
	
	boolean go = true;
	
	public int rentManagement() {
		
		boolean lo = true;
		
		while(lo) {
			System.out.println("==================================");
			System.out.println("1.대여|2.반납|3.대여현황|4.돌아가기|5.종료");
			System.out.println("==================================");
			System.out.print("입력란:");
			
			int rm = sc.nextInt();
			String err = sc.nextLine();
			switch (rm) {

			case 1:
				// 대여
				System.out.print("회원아이디:");
				String id = sc.nextLine();
				System.out.print("대여하실 책번호:");
				int booknum = sc.nextInt();
				rentDao.rentIntwo(id, booknum);
				break;

			case 2:
				// 반납
				System.out.print("반납하실 책번호:");
				int returnbooknum = sc.nextInt();
				rentDao.rentUptwo(returnbooknum);
				break;
				
			case 3:
				//대여현황
				System.out.println("*대여현황*");
				rentDao.rentSelect();
				
				System.out.println("뒤로 가실라면 아무키나 입력하십시오");
				String back = sc.nextLine();
				
				break;
				
			case 4:
				//돌아가기
				lo = false;
				break;
				
			case 5:
				//종료
				lo = false;
				System.out.println("프로그램 종료");
				return 0;
				
			default:
				System.out.println("다시 입력해주세요");

			}//rm
			
		}//lo
		
		
		
		return 1;
		
	}//rentManament
	
	

}
