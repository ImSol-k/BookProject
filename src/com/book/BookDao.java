package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookDao {
	
	List<BookVo> bookList = new ArrayList<BookVo>();
	BookVo bookVo;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public void bookSetting() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/library_db";
			conn = DriverManager.getConnection(url, "library", "library");
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		
	}
	
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

	public void bookSelect() {

		try {
			System.out.println("select");
			bookSetting();
			
			String query = "";
			query += " select book_id,";
			query += " 		  title";
			query += " from library";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			
			int id;
			String name;
			while (rs.next()) {

				id = rs.getInt("book_id");
				name = rs.getString("title");
				bookVo = new BookVo(id, name);
				bookList.add(bookVo);

			}
			System.out.println("select");
//			for (int i = 0; i < bookList.size(); i++) {
//				System.out.println(bookList.get(i).toString());
//			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		close();

	}

	public void bookInsert() {

	}

	public void bookDelete() {

	}

	public void bookUpdate() {

	}

}
