package com.library;

import java.sql.SQLException;

public class MemeberApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		MemberSystem MSystem = new MemberSystem();

		EXIT: while (true) {
			
			int menu = MSystem.inputNoticeMenu();// 입력창
					
			switch (menu) {
			case 1: // 회원가입
				MSystem.insertMenu();
				break;
				
			case 2: // 로그인
				MSystem.inputLoginMenu();
				break;
				
			case 3: // 종료
				System.out.println("종료되었습니다. 안녕히가세요!.");
				break EXIT;
				
			default:
				System.out.println(" ");
				break;

			}

		}
	}



}
