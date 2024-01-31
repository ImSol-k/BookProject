package com.library;

public class RentTest {

	public static void main(String[] args) {
		
		RentDao rentDao = new RentDao();
		RentVo rentVo = new RentVo();
		MemberVo memberVo = new MemberVo();
		//rentDao.rentSelect();
		
		//rentDao.rentInsert(rentVo);
		
		//rentDao.rentDelete(2);
		
		//rentDao.rentUpdate(rentVo);
		
		rentDao.rentIntwo("qwe", 3);

	}

}
