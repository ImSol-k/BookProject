package com.library;

import java.util.Scanner;

public class MemberTest {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		MemberManager mm = new MemberManager();
		boolean start = true;
		int num;
		
		
		while(start) {
			System.out.println("1.히스토리 2.정보수정 3.책리스트 4.돌아가기 5.종료");
			System.out.print(">> ");
			num = in.nextInt();
			in.nextLine();
			switch(num) {
			case 1:
				mm.myHistory();
				start = true;
				break;
			case 2:
				start = true;
				break;
			case 3:
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
	}//main()

}//class()
