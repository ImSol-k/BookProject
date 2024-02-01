package com.library;

import java.util.Scanner;

public class ManagerSystem {
	
	RentDao rentDao =new RentDao();
	MemberVo memberVo = new MemberVo();

	Scanner sc = new Scanner(System.in);
	
	boolean go = true;
	
	public void managerMain() {

		

		while (go) {

			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("===============================");
			System.out.println("1.대여관리|2.회원관리|3.책관리|4.종료");
			System.out.println("===============================");
			System.out.print("입력란:");

			int choose = sc.nextInt();

			switch (choose) {

					case 1:
						// 대여관리
						rentManagement();
						break;

					case 2:
						// 회원관리
						
						break;
						
					case 3:
						//책관리
						
						break;
						
					case 4:
						//종료
						go = false;
						System.out.println("프로그램 종료");
						break;
						
					default:
						System.out.println("다시 입력해주세요");

			}// choose

		} // go

	}//managerMain
	
	public void rentManagement() {
		
		boolean lo = true;
		
		while(lo) {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
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
				
				System.out.println("뒤로 가실라면 1을 입력해주세요");
				System.out.print("입력란:");
				int back = sc.nextInt();
				if(back == 1) {
					rentManagement();
				}else {
					System.out.println("1을 입력해주세요");
					return;
				}
				break;
				
			case 4:
				//돌아가기
				managerMain();
				break;
				
			case 5:
				//종료
				lo = false;
				go = false;
				System.out.println("프로그램 종료");
				break;
				
			default:
				System.out.println("다시 입력해주세요");

			}//rm
			
		}//lo
		
		
		
		
		
	}//rentManament
	
	//public rent

}
