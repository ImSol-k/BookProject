package com.library;

import java.util.Scanner;

//로그인 성공했을때 하위메뉴와 기능

public class MemberLogin {

	public int loginMain(String id) {
		
		Scanner in = new Scanner(System.in);
		BookDao bookDao = new BookDao(); 
		RentDao rentDao = new RentDao();
		MemberDao memberDao= new MemberDao();
		boolean start = true;
		int num =0;
		
		
		while(start) {
			System.out.println("1.히스토리 2.정보수정 3.책리스트 4.종료");
			System.out.print(">> ");
			num = in.nextInt();
			in.nextLine();
			switch(num) {
			case 1:
				rentDao.myHistory(id);
				start = true;
				break;
				
			case 2:
				System.out.println("회원수정 위해 필요한 정보를 입력하세요.");
			
				System.out.print("password = ");
				String password = in.nextLine();
				System.out.print("name = ");
				String name = in.nextLine();
				System.out.print("ph = ");
				String ph = in.nextLine();
				System.out.print("address = ");
				String address = in.nextLine();

				// 입력받은 데이터 member에 저장.
				MemberVo member = new MemberVo(id, password, name, ph, address);
				memberDao.memberInfoUpdate(member);
				start = true;
				break;
				
			case 3:
				System.out.println("<책리스트>");
				bookDao.bookSelect();
				start = true;
				break;
			case 4:
				return 0;
			default:
				System.out.println("잘못 입력하셨습니다.");
				start = true;
				break;
			}
		}
		in.close();
		return num;
		
	}//main()

}//class()
