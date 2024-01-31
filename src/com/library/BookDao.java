package com.library;

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
	private int bookId;
	private String title, authorName, pubs, pub_date;

	// DB연결
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

	}//bookSetting()

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
	}//close()

	//데이터 불러오기
	public void bookSelect() {

		try {
			bookSetting();

			String query = "";
			query += " select book_id,";
			query += " 		  title,";
			query += " 		  author,";
			query += " 		  pubs,";
			query += " 		  pub_date";
			query += " from librarys";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bookId = rs.getInt("book_id");
				title = rs.getString("title");
				authorName = rs.getString("author");
				pubs = rs.getString("pubs"); 
				pub_date = rs.getString("pub_date");

				bookVo = new BookVo(bookId, title, authorName, pubs, pub_date);
				bookList.add(bookVo);
				
				

			}
			System.out.println("불러오기 완료"); //확인용
			// System.out.println("select"); //확인용
//			for (int i = 0; i < bookList.size(); i++) {
//				System.out.println(bookList.get(i).toString());
//			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();

	}//bookSelect()

	
	public void showList() {
		try {
			bookSetting();

			String query = "";
			query += " select book_id,";
			query += " 		  title,";
			query += " 		  author,";
			query += " 		  pubs,";
			query += " 		  pub_date";
			query += " from librarys";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bookId = rs.getInt("book_id");
				title = rs.getString("title");
				authorName = rs.getString("author");
				pubs = rs.getString("pubs"); 
				pub_date = rs.getString("pub_date");

				bookVo = new BookVo(bookId, title, authorName, pubs, pub_date);
				//bookList.add(bookVo);
				
				

			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i).toString());
		}
	}//showList()

	public void bookInsert(BookVo book) {
		bookSetting();

		try {
			//System.err.println("insert"); //확인용
			String query = "";
			query += " insert into librarys";
			query += " values (null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPubs());
			pstmt.setString(4, book.getPubDate());
			
			pstmt.executeUpdate();
			System.out.println("등록 되었습니다.");
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}//bookInsert()

	public void bookDelete(int num) {
		bookSetting();

		try {
			System.out.println("delete"); //확인용
			
			String query = "";
			query += " delete from librarys";
			query += " where book_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);

			pstmt.executeUpdate();
			System.out.println("삭제 되었습니다.");
			bookList.remove(num - 1);

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}//bookDelete()

	public void bookUpdate(BookVo book) {
		
		bookSetting();
		
		try {
			System.out.println("upDate"); //확인용
			String query = "";
			query += " update librarys";
			query += "    set title = ?,";
			query += " 		  author = ?,";
			query += " 		  pubs = ?,";
			query += " 		  pub_date = ?";			
			query += " where book_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPubs());
			pstmt.setString(4, book.getPubDate());
			//pstmt.setInt(7, book.getMemberId());
			pstmt.setInt(5, book.getBookId());

			// rs = pstmt.executeQuery();
			pstmt.executeUpdate();
			System.out.println("수정되었습니다");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}//bookUpdate()

}
