package com.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberManager {
	
	private List<RentVo> rentList = null;
	private RentVo rentVo;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private void getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/library_db";
			conn = DriverManager.getConnection(url, "library", "library");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}// getConnection()

	private void close() {

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
	
	
	public void myHistory() {
		
		MemberSystem ms = new MemberSystem();
		rentList = new ArrayList<RentVo>();
		try {
			getConnection();

			System.out.println("<히스토리>");
			String query = "";
			query += " select name,";
			query += " 		  title,";
			query += " 		  rent_date,";
			query += " 		  return_date";
			query += " from librarys l, members m, rents r";
			query += " where m.member_num = (select member_num from members where member_id = ?)";
			query += " and l.book_id = r.book_id";
			pstmt.setString(1, ms.inputLoginMenu());
			
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			String name, title, rentDate, returnDate;
			while (rs.next()) {
				name = rs.getString("name");
				title = rs.getString("title");
				rentDate = rs.getString("rent_date");
				returnDate = rs.getString("return_date");

				rentVo= new RentVo(rentDate, returnDate, name, title);
				rentList.add(rentVo);

			}
			// System.out.println("불러오기 완료"); //확인용
			// System.out.println("select"); //확인용
			for (int i = 0; i < rentList.size(); i++) {
				// System.out.println(bookList.get(i).toString());
				System.out.println(rentList.get(i).toString());
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
		
		   
	       
	       
	
	
	  
	}
	
	
	
	
}
