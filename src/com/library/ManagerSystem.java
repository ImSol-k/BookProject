package com.library;

import java.util.Scanner;

public class ManagerSystem {
	
	RentDao rentDao =new RentDao();
	MemberVo memberVo = new MemberVo();

	Scanner sc = new Scanner(System.in);

	public void managerMain() {

		boolean go = true;

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
			String cc = sc.nextLine();
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
				
				break;
				
			case 3:
				//대여현황
				
				break;
				
			case 4:
				//돌아가기
				managerMain();
				break;
				
			case 5:
				//종료
				lo = false;
				break;
				
			default:
				System.out.println("다시 입력해주세요");

			}//rm
			
		}//lo
		
		
		
		
		
	}//rentManament
	
	

}
