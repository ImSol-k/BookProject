package com.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	
	// 필드
		private Connection conn = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;

		private String driver = "com.mysql.cj.jdbc.Driver";
		private String url = "jdbc:mysql://localhost:3306/library_db";
		private String id = "library";
		private String pw = "library";

		// 생성자
		// 기본생성자 사용 (써주지 않아도 기본으로 제공되어있음)

		// 메소드 gs

		// 일반메소드
		private void getConnection() {

			try {
				// 1. JDBC 드라이버 (Oracle) 로딩
				Class.forName("com.mysql.cj.jdbc.Driver");

				// 2. Connection 얻어오기
				String url = "jdbc:mysql://localhost:3306/library_db";
				conn = DriverManager.getConnection(url, "library", "library");

			} catch (ClassNotFoundException e) {
				System.out.println("error: 드라이버 로딩 실패 - " + e);
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}// getConnection()

		private void close() {

			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);

			}
		}// close()

		/***********************************************************************
		 ** - 회원가입
		 ************************************************************************/
		public int MemberVoInsert(String member_id, String member_pw, String name, String ph, String address)
				throws ClassNotFoundException, SQLException {

			int result = 0;

			this.getConnection();

			try {

				// 3. SQL문 준비 / 바인딩 / 실행
				// -SQL문 준비
				String query = "";
				query += "  insert into members ";
				query += "  value(null,?,?,?,?,?) ";

				// -바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, member_id);
				pstmt.setString(2, member_pw);
				pstmt.setString(3, name);
				pstmt.setString(4, ph);
				pstmt.setString(5, address);

				// -실행
				result = pstmt.executeUpdate();

				// 4.결과처리
				System.out.println("회원가입이 완료되었습니다. 환영합니다!");

				System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯ '" + name + "' 회원 정보 ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
				System.out.println("id = " + member_id);
				System.out.println("password = " + member_pw);
				System.out.println("name = " + name);
				System.out.println("ph = " + ph);
				System.out.println("address = " + address);

			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

			this.close();

			return result;

		}// MemberVoInsert

		/***********************************************************************
		 ** - 로그인 Data
		 * 
		 * @throws SQLException
		 ************************************************************************/
		public MemberVo MemberData(String member_id, String member_pw) throws ClassNotFoundException, SQLException {

			MemberVo memberVo = null;

			 //int result = -1;

			this.getConnection();

			try {

				// 3. SQL문 준비 / 바인딩 / 실행
				// -SQL문 준비
				String query = "";
				query += "  select member_id, ";
				query += "         member_pw ";
				query += "  from members ";
				query += "  where member_id in (?,?) ";

				// -바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, member_id);
				pstmt.setString(2, member_pw);

				// -실행
				rs = pstmt.executeQuery();

				// 4.결과처리

				if (rs.next()) {
					memberVo = new MemberVo();
					memberVo.setMember_id(rs.getString("member_id"));
					memberVo.setMember_pw(rs.getString("Member_pw"));

				}

			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

			this.close();
			//rs.close();
			pstmt.close();
			return memberVo;

		}
		
	

}
