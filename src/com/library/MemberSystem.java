package com.library;

import java.sql.SQLException;
import java.util.Scanner;

public class MemberSystem {

	private MemberDao dao;
	private String id;

	public MemberSystem() {
		dao = new MemberDao();
	}

	/****************************************************************
	 * 메인 로그인 화면
	 *****************************************************************/
	public int inputNoticeMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.print(" 1.로그인 / 2.회원가입 / 3. 종료 \n>> ");
		int menu = sc.nextInt();
		return menu;
	}
	

	/************* 회원가입 ****************/
	public void insertMenu() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("회원가입을 위해 필요한 정보를 입력하세요.");
		System.out.print("id = ");
		String id = sc.nextLine();
		System.out.print("password = ");
		String password = sc.nextLine();
		System.out.print("name = ");
		String name = sc.nextLine();
		System.out.print("ph = ");
		String ph = sc.nextLine();
		System.out.print("address = ");
		String address = sc.nextLine();

		// 입력받은 데이터 member에 저장.
		MemberVo member = new MemberVo(id, password, name, ph, address);

		dao.MemberVoInsert(id, password, name, ph, address);

	}

	/************* 로그인 ****************/
	public String inputLoginMenu() {

		Scanner sc = new Scanner(System.in);
		MemberLogin login = new MemberLogin();

		try {
			boolean b = true;
			while (b) {
				System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯ 회원 로그인 ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
				System.out.println(" 로그인을 위한 회원정보를 입력하세요 >> ");
				System.out.print(" id = ");
				String id = sc.nextLine();
				System.out.print(" password = ");
				String password = sc.nextLine();

				MemberVo vo = dao.MemberData(id, password);
				
				if (vo == null) {
					System.out.println("아이디나 비밀번호가 다릅니다. 다시 입력해주세요.");

				} else {
					System.out.println("로그인 성공! 환영합니다.");
					System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
					login.loginMain(id);
					
					b = false;
				}
			}
		} catch (Exception e) {

		}
		return id;

	}

	/****************************************************************
	 * 로그인 완료 후 메인 화면
	 *****************************************************************/
	/*public int inputLoginmainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.print(" 1. 회원 히스토리 / 2.정보수정 / 3. 책 리스트  /4. 돌아가기 /5. 종료");
		int num = sc.nextInt();
		return num;
	}*/

}
