package com.library;

import java.sql.SQLException;

public class MemberApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		MemberSystem mSystem = new MemberSystem();

		System.out.println("<도서대여 관리 프로그램>");
		System.out.println("<회원>");
		
		boolean action = true;
		while (action) {
			
			int menu = mSystem.inputNoticeMenu();// 입력창
					
			switch (menu) {
			case 1: // 로그인\
				mSystem.inputLoginMenu();
				break;
				
			case 2: // 회원가입				
				mSystem.insertMenu();
				break;
				
			case 3: // 종료
				System.out.println("종료되었습니다. 안녕히가세요!.");
				action=false;
				break ;
				
			default:
				System.out.println("메뉴를 다시입력해주세요");
				break;

			}

		}
	}



}
