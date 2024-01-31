package com.library;

public class RentVo {

	private int rentId;
	private int bookId;
	private int membernum;
	private String rentdate;
	private String returndate;

	public RentVo() {
		super();
	}

	public RentVo(int rentId, int membernum, int bookId, String rentdate, String returndate) {
		super();
		this.rentId = rentId;
		this.bookId = bookId;
		this.membernum = membernum;
		this.rentdate = rentdate;
		this.returndate = returndate;
	}

	public int getRentId() {
		return rentId;
	}

	public void setRentId(int rentId) {
		this.rentId = rentId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getMembernum() {
		return membernum;
	}

	public void setMembernum(int membernum) {
		this.membernum = membernum;
	}

	public String getRentdate() {
		return rentdate;
	}

	public void setRentdate(String rentdate) {
		this.rentdate = rentdate;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}

	@Override
	public String toString() {
		return "RentVo [rentId=" + rentId + ", bookId=" + bookId + ", membernum=" + membernum + ", rentdate=" + rentdate
				+ "]";
	}

}
