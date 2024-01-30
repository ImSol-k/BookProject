package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookDao {
	
	private List<BookVo> bookList = new ArrayList<BookVo>();
	private BookVo bookVo;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private int bookId, memberId;
	private String title, authorName, pubs, pub_date, rent, rentDate;
	
	//DB연결
	public void bookSetting() {
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
	
	//자원정리
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
			//System.out.println("select"); //확인용
			bookSetting();
			
			String query = "";
			query += " select book_id,";
			query += " 		  title,";
			query += " 		  author_name,";
			query += " 		  pubs,";
			query += " 		  pub_date,";
			query += " 		  rent,";
			query += " 		  rent_date,";
			query += " 		  member_id";
			query += " from library";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			
			
			while (rs.next()) {				
				bookId = rs.getInt("book_id");
				title = rs.getString("title");
				authorName = rs.getString("author_name");
				pubs = rs.getString("pubs");
				pub_date = rs.getString("pub_date");
				rent = rs.getString("rent");
				rentDate = rs.getString("rent_date");
				memberId = rs.getInt("member_id");
				
				bookVo = new BookVo(bookId, title, authorName, pubs, pub_date, rent, rentDate);
				bookList.add(bookVo);

			}
			//System.out.println("select"); //확인용
//			for (int i = 0; i < bookList.size(); i++) {
//				System.out.println(bookList.get(i).toString());
//			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		close();

	}
	
	public void showList() {
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i).toString());
		}
	}

	public void bookInsert(BookVo book) {
		bookSetting();

		try {
			String query = "";
			query += " insert into library";
			query += " values (null, ?, ?, ?, ?, ?, ?, null)";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPubs());
			pstmt.setString(4, book.getPubDate());
			pstmt.setString(5, book.getRent());
			pstmt.setString(6, book.getRentDate());
			//pstmt.setInt(7, book.getMemberId());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}

	public void bookDelete() {
		bookSetting();

		try {
			String query = "";
			query += " delete from library";
			query += " where book_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);

			pstmt.executeUpdate();
			System.out.println(count + "건 삭제 되었습니다.");
			authorList.remove(num - 1);

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}

	public void bookUpdate() {

	}

}
