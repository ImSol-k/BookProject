package com.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

	private List<BookVo> bookList = null;
	private BookVo bookVo;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private int bookId;
	private String title, authorName, pubs, pub_date, state;

	/************************************
	 * DB연결
	 */
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

	}// bookSetting()

	/************************************
	 * 자원정리
	 */
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
	}// close()

	/************************************
	 * Select
	 */
	public void bookSelect() {
		bookList = new ArrayList<BookVo>();
		try {
			bookSetting();

			String query = "";
			query += " select l.book_id, title, author, pubs, pub_date, r.rent_id, r.member_num, rent_date, return_date, ";
			query += " 		  case when (rent_date = null) or (rent_date is not null and return_date is not null) then '대여가능'";
			query += " 		       else '대여중' end 'state'";
			query += " from librarys l left join ( select s.rent_id, s.member_num, s.book_id, s.rent_date, return_date ";
			query += " 		  						 from rents s, (select max(rent_id) rent_id";
			query += " 		  										  from rents group by book_id) b where s.rent_id = b.rent_id) r ";
			query += " on l.book_id = r. book_id";
			
			
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("sakbfjbs");
				bookId = rs.getInt("book_id");
				title = rs.getString("title");
				authorName = rs.getString("author");
				pubs = rs.getString("pubs");
				pub_date = rs.getString("pub_date");
				state = rs.getString("state");
				
				
				System.out.println("sakbfjbs");
				
				bookVo = new BookVo(bookId, title, authorName, pubs, pub_date, state);
				bookList.add(bookVo);
			}
			
			// System.out.println("불러오기 완료"); //확인용
			// System.out.println("select"); //확인용
			for (int i = 0; i < bookList.size(); i++) {
				// System.out.println(bookList.get(i).toString());
				bookList.get(i).showInfo();
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();

	}// bookSelect()

	/************************************
	 * Insert
	 */
	public void bookInsert(BookVo book) {
		bookSetting();

		try {
			// System.out.println("insert" + book); //확인용
			String query = "";
			query += " insert into librarys";
			query += " values (null";
			query += " , ?";
			// System.out.println("if");
			if (book.getAuthor() != "") {
				query += " , ?";
			} else {
				query += " , null";
			}
			if (book.getPubs() != "") {
				query += " , ?";
			} else {
				query += " , null";
			}
			if (book.getPubDate() != "") {
				query += " , ?";
			} else {
				query += " , null";
			}
			query += " )";

			// System.out.println("query" + query);

			pstmt = conn.prepareStatement(query);

			int count = 1;
			pstmt.setString(1, book.getTitle());
			if (book.getAuthor() != "") {
				count++;
				pstmt.setString(count, book.getAuthor());
			}
			if (book.getPubs() != "") {
				count++;
				pstmt.setString(count, book.getPubs());
			}
			if (book.getPubDate() != "") {
				count++;
				pstmt.setString(count, book.getPubDate());
			}

			pstmt.executeUpdate();
			System.out.println("등록 되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}// bookInsert()

	/************************************
	 * Delete
	 */
	public void bookDelete(int num) {
		bookSetting();

		try {
			// System.out.println("delete"); //확인용

			String query = "";
			query += " delete from librarys";
			query += " where book_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);

			pstmt.executeUpdate();
			// System.out.println("삭제 되었습니다.");
			bookList.remove(num - 1);

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}// bookDelete()

	/************************************
	 * Update
	 */
	public void bookUpdate(BookVo book) {
		bookSetting();

		try {
			// System.out.println("upDate"); //확인용
			String query = "";

			query += " update librarys";
			query += "    set book_id = ?";

			if (book.getTitle() != "") {
				query += ", 		  title = ?";
			}
			if (book.getAuthor() != "") {
				query += ", 		  author = ?";
			}
			if (book.getPubs() != "") {
				query += ", 		  pubs = ?";
			}
			if (book.getPubDate() != "") {
				query += ", 		  pub_date = ?";
			}
			query += " where book_id = ?";

			// System.out.println(query);
			// System.out.println(book);

			pstmt = conn.prepareStatement(query);

			int count = 1;
			pstmt.setInt(count, book.getBookId());

			if (book.getTitle() != "") {
				count++;
				pstmt.setString(count, book.getTitle());
			}
			if (book.getAuthor() != "") {
				count++;
				pstmt.setString(count, book.getAuthor());
			}
			if (book.getPubs() != "") {
				count++;
				pstmt.setString(count, book.getPubs());
			}
			if (book.getPubDate() != "") {
				count++;
				pstmt.setString(count, book.getPubDate());
			}
			if (book.getBookId() != 0) {
				count++;
				pstmt.setInt(count, book.getBookId());
			}
			// rs = pstmt.executeQuery();
			pstmt.executeUpdate();
			// System.out.println("수정되었습니다");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();

	}// bookUpdate()

	/************************************
	 * Find
	 */
	public void bookFind(int num, String str) {
		
		BookSystem bookS = new BookSystem();
		bookList = new ArrayList<BookVo>();
		
		try {
			bookSetting();

			String query = "";
			query += " select book_id,";
			query += "		  title,";
			query += "		  author,";
			query += "		  pubs,";
			query += "		  pub_date";
			query += " from librarys";
			//System.out.println("bookFind");
			
			switch(num) {
			case 1:
				query += " where title = ?";				
				break;
			case 2:
				query += " where author = ?";
				break;
			case 3:
				query += " where book_id = ?";
				break;
			}
			
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, str);

			rs = pstmt.executeQuery();
			boolean where = false;
			while (rs.next()) {
				where = true;
				bookId = rs.getInt("book_id");
				title = rs.getString("title");
				authorName = rs.getString("author");
				pubs = rs.getString("pubs");
				pub_date = rs.getString("pub_date");

				bookVo = new BookVo(bookId, title, authorName, pubs, pub_date);
				bookList.add(bookVo);

			}
			if (where) {
				for (int i = 0; i < bookList.size(); i++) {
					bookList.get(i).showInfo();
				}
			} else {
				System.out.println("검색결과 없음");
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
		
		//System.out.println("종료");
	}// bookFind()

}
