package com.library;

public class RentVo {

	private int rentId;
	private int bookId;
	private int membernum;
	private String rentdate;
	private String returndate;
	private String member_id;
	private String member_pw;
	private String name;
	private String ph;
	private String address;
	private String title;
	private String author;
	private String pubs;
	private String pubDate;

	public RentVo() {
	}

	
	
	public RentVo(String member_id) {
		this.member_id = member_id;
	}



	public RentVo(String rentdate, String returndate) {
		this.rentdate = rentdate;
		this.returndate = returndate;
	}

	public RentVo(String rentdate, String returndate, String name, String title) {
		this.rentdate = rentdate;
		this.returndate = returndate;
		this.name = name;
		this.title = title;
	}

	public RentVo(int rentId, int membernum, int bookId, String rentdate, String returndate) {
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

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	@Override
	public String toString() {
		return "RentVo [rentId=" + rentId + ", bookId=" + bookId + ", membernum=" + membernum + ", rentdate=" + rentdate
				+ ", returndate=" + returndate + ", member_id=" + member_id + ", member_pw=" + member_pw + ", name="
				+ name + ", ph=" + ph + ", address=" + address + ", title=" + title + ", author=" + author + ", pubs="
				+ pubs + ", pubDate=" + pubDate + "]";
	}

	public void showrent() {
		System.out.println("책번호:" + bookId + "\t회원번호:" + membernum + "\t대여일:" + rentdate + "\t반납일:" + returndate);
		
		
	}

}
