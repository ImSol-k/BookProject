package com.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentDao {

	private List<RentVo> rentList = new ArrayList<RentVo>();
	private RentVo rentVo;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private int rentId, bookId, membernum;
	private String rentdate, returndate;

	Scanner sc = new Scanner(System.in);

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
				rentVo.showrent();

				// System.out.println("select"); //확인용

			}
			// System.out.println("select"); //확인용
			// for (int i = 0; i < rentList.size(); i++) {
			// System.out.println(rentList.get(i).toString());
			// }

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
			// System.out.println("upDate"); // 확인용
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

			// System.out.println("upDate");
			pstmt.executeUpdate();
			System.out.println("수정되었습니다");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}// rentUpdate()


	public void rentIntwo(String member, int bookId) {

		rentSetting();

		// qwe 3번책

		// db에서 qwe 3번 (조회) 대여중, 대여가능

		// 만약에 대여가능 (저장) 메세지출력

		// 만약에 대여중 메세지출력

		// MemberVo memVo = new MemberVo();
		RentVo renVo = new RentVo();
		String date = "";
		int num = 0;
		String memid = "";
		try {
			// System.out.println("insert"); //확인용
			/************************
			 * 책번호찾기
			 */
			String query = "";
			query +=  " select book_id";
			query +=  " from rents";			
			query +=  " where member_num = (select member_num";
			query +=  " 				     from members";
			query +=  " 					where member_id = ?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member);	
			rs = pstmt.executeQuery();

			while(rs.next()) {
			num = rs.getInt("book_id");
			}
			//System.out.println(num);
			
			/************************
			 * 찾은 책의 반납여부 확인
			 */
			query = "";
			query += " select return_date ";
			query += "   from rents ";
			query += " where book_id = ? ";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				date = rs.getString("return_date");
			}
			//System.out.println(date);
			//System.out.println("WWWW");
			query = "";
			query += " select member_id ";
			query += " from members ";
			query += " where member_id = ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member);
			
			rs = pstmt.executeQuery();
			//System.out.println("WWWW");
			
		    while(rs.next()) {
		    	memid = rs.getString("member_id");
		    }
			
			query = "";
			query += " insert into rents";
			query += " values (null, (select member_num"
					+ "					     from members"
					
					+ "					     where member_id = ?), ?, date_format(now(),'%Y-%m-%d'), null)";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member);
			pstmt.setInt(2, bookId);
			
			if(memid.equals("")){
				//대여불가
			    System.out.println("잘못된 아이디 입니다.");
			}else if(date == null) {
				//대여불가
				System.out.println("대여중인 책입니다.");
			}
			else {
				//대여가능
				pstmt.executeUpdate();
				System.out.println("대여 되었습니다.");
			}
			

			//if () {

			//} else if (renVo.getRentdate() == null && renVo.getReturndate() == null) {
			//	pstmt.executeUpdate();
			//	System.out.println("대여 되었습니다.");
			//}
			 //System.out.println(renVo.getRentdate());

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}// rentIntwo()

	public void rentUptwo(int bookid) {

		rentSetting();

		try {
			// System.out.println("upDate"); // 확인용
			String query = "";
			query += " update rents";
			query += "    set return_date =  date_format(now(),'%Y-%m-%d')";
			query += " where book_id = (select book_id";
			query += " 		  			from librarys";
			query += " 		  			where book_id = ?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,bookid);
			

			// System.out.println("upDate");
			pstmt.executeUpdate();
			System.out.println("반납되었습니다");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}// rentuptwo()

}
