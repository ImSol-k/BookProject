package com.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentDao {

	private List<RentVo> rentList = new ArrayList<RentVo>();
	private RentVo rentVo;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private int rentId,bookId,membernum;
	private String rentdate,returndate;

	// DB연결
	public void rentSetting() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/library_db";
			conn = DriverManager.getConnection(url, "library", "library");
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}

	// 자원정리
	public void close() {
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
	}
	
	public void rentSelect() {

		try {
			System.out.println("select"); //확인용
			rentSetting();

			String query = "";
			query += " select rent_id, ";
			query += " 		  member_num, ";
			query += " 		  book_id, ";
			query += " 		  rent_date, ";
			query += " 		  return_date ";
			query += " from rents";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			System.out.println("select"); //확인용
			while (rs.next()) {
				rentId = rs.getInt("rent_id");
				membernum = rs.getInt("member_num");
				bookId = rs.getInt("book_id");
				rentdate = rs.getString("rent_date");
				returndate = rs.getString("retrun_date");

				rentVo = new RentVo(rentId, membernum,bookId,rentdate,returndate);
				rentList.add(rentVo);
				
				System.out.println("select"); //확인용

			}
			 System.out.println("select"); //확인용
		  for (int i = 0; i < rentList.size(); i++) {
				System.out.println(rentList.get(i).toString());
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();

	}
	
	public void rentbook() {
		
		
		
		
		
		
	}


	
	
	
	
}
