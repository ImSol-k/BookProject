package com.book;

import java.util.Scanner;

public class BookSystem {
	
	Scanner sc = new Scanner(System.in);
	
	public void main() {
		//메인화면
		
		while(true) {
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("===============================");
			System.out.println("   1.회원      |     2.관리자    |");
			System.out.println("===============================");
			System.out.print("입력란:");
			
			int choose =sc.nextInt();
			
			switch(choose) {
				
					case 1:
						//회원
						member();
						break;
						
					case 2:
						//관리자
						administrator();
						break;
			
			
			}//choose
			
			
			
		}//while
		
		
	}//main
	
	public void member() {
		//회원
		boolean in = true;
		
		while(in) {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("=============================");
			System.out.println(" 1.로그인 | 2.회원가입 | 3.뒤로가기 ");
			System.out.println("=============================");
			System.out.print("입력란:");
			
			int mem = sc.nextInt();
			
			switch(mem) {
			
					case 1:
						//로그인
						log();
						break;
					
					case 2:	
						//회원가입
						break;
						
					case 3:	
						main();
						break;
			}//swich(mem)			
		
		}//in
		
	}//member
	
	public void administrator() {
		//관리자
		boolean on = true;
		
		while(on) {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("=========================================");
			System.out.println(" 1.대여현황 | 2.회원리스트 | 3.책관리 | 4.뒤로가기");
			System.out.println("=========================================");
			System.out.print("입력란:");
			
			int mg = sc.nextInt();
			
			switch(mg) {
					
					case 1:
						//대여현황
						break;
						
					case 2:
						//회원리스트
						break;
						
					case 3:
						//책관리
						break;
						
					case 4:
						main();
						break;//나가기
						
						
						
					default:
						//잘못된 번호 오류표시
						System.out.println("다시 입력해주세요");
						break;
			
			
			}//mg
		
		}//on
		
		
	}
	
	public void log() {
		//로그인
		while(true) {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("=================================================================");
			System.out.println(" 1.대여하기 | 2.반납하기 | 3.회원정보수정하기 | 4.나의 대여 및 반납 | 5.뛰로가기");
			System.out.println("=================================================================");
			System.out.print("입력란:");
			
			int lo =sc.nextInt();
			
			switch(lo) {
					
					case 1:
						break;
						
					
					case 2:
						break;
						
						
						
					case 3:
						break;
						
						
					case 4:
						break;
						
						
					case 5:
						member();
						break;
			
			
			
			}//lo
			
		}//while
		
		
	}//log

}
