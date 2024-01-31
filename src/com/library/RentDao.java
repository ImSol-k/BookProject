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
	private int rentId, bookId, membernum;
	private String rentdate, returndate;

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
			// System.out.println("select"); //확인용
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
			while (rs.next()) {
				rentId = rs.getInt("rent_id");
				membernum = rs.getInt("member_num");
				bookId = rs.getInt("book_id");
				rentdate = rs.getString("rent_date");
				returndate = rs.getString("return_date");

				rentVo = new RentVo(rentId, membernum, bookId, rentdate, returndate);
				rentList.add(rentVo);

				// System.out.println("select"); //확인용

			}
			// System.out.println("select"); //확인용
			//for (int i = 0; i < rentList.size(); i++) {
				//System.out.println(rentList.get(i).toString());
			//}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();

	}

	public void rentInsert(RentVo rent) {

		rentSetting();

		try {
			// System.out.println("insert"); //확인용
			String query = "";
			query += " insert into rents";
			query += " values (null, null, null, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rent.getRentdate());
			pstmt.setString(2, rent.getReturndate());

			pstmt.executeUpdate();
			System.out.println("insert");
			System.out.println("등록 되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}// rentInsert()

	public void rentDelete(int num) {
		rentSetting();

		try {
			// System.out.println("delete"); //확인용

			String query = "";
			query += " delete from rents";
			query += " where rent_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);

			pstmt.executeUpdate();
			System.out.println("삭제 되었습니다.");

			// System.out.println("delete");
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}// rentDelete()

	public void rentUpdate(RentVo rent) {

		rentSetting();

		try {
			System.out.println("upDate"); // 확인용
			String query = "";
			query += " update rents";
			query += "    set member_num= ?,";
			query += " 		  book_id = ?,";
			query += " 		  rent_date = ?,";
			query += " 		  return_date = ?";
			query += " where rent_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rent.getMembernum());
			pstmt.setInt(2, rent.getBookId());
			pstmt.setString(3, rent.getRentdate());
			pstmt.setString(4, rent.getReturndate());
			pstmt.setInt(5, rent.getRentId());

			System.out.println("upDate");
			pstmt.executeUpdate();
			System.out.println("수정되었습니다");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}// bookUpdate()

}
