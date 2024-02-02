package com.library;

import java.util.Scanner;

public class MemberLogin {

	public int loginMain() {
		
		Scanner in = new Scanner(System.in);
		MemberManager mm = new MemberManager();
		BookDao bookDao = new BookDao(); 
<<<<<<< HEAD
		
=======
		RentDao rentDao = new RentDao();
		MemberDao memberDao= new MemberDao();
>>>>>>> refs/remotes/origin/master
		boolean start = true;
		int num =0;
		
		
		while(start) {
<<<<<<< HEAD
			System.out.println("1.히스토리 2.정보수정 3.책리스트 4.돌아가기 5.종료");
=======
			System.out.println("1.히스토리 2.정보수정 3.책리스트 4.로그아웃");
>>>>>>> refs/remotes/origin/master
			System.out.print(">> ");
			num = in.nextInt();
			in.nextLine();
			switch(num) {
			case 1:
				mm.myHistory();
				start = true;
				break;
				
			case 2:
<<<<<<< HEAD
				
=======
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
>>>>>>> refs/remotes/origin/master
				start = true;
				break;
				
			case 3:
				System.out.println("<책관리>");
				bookDao.bookSelect();
				start = true;
				break;
			case 4:
				start = true;
				break;
			case 5:
				start = false;
				break;
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
