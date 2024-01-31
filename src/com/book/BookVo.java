package com.book;

public class BookVo {
	
	private int bookId;
	private String title;
	private String author;
	private String pubs;
	private String pubDate;
	private String rent;
	private String rentDate;
	private int memberId;
	
	public BookVo(int bookId, String title) {
		super();
		this.bookId = bookId;
		this.title = title;
	}
	public BookVo(int bookId, String title, String author, String pubs, String pubDate) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.pubs = pubs;
		this.pubDate = pubDate;
	}
	public BookVo(String title, String author, String pubs, String pubDate) {
		super();
		this.title = title;
		this.author = author;
		this.pubs = pubs;
		this.pubDate = pubDate;
	}
	public BookVo(int bookId, String title, String author, String pubs, String pubDate, String rent, String rentDate) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.rent = rent;
		this.rentDate = rentDate;
	}
	public BookVo(int bookId, String title, String author, String pubs, String pubDate, String rent, String rentDate,
			int memberId) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.rent = rent;
		this.rentDate = rentDate;
		this.memberId = memberId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
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
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	@Override
	public String toString() {
		return "[bookId=" + bookId + ", title=" + title + ", author=" + author + ", pubs=" + pubs + ", pubDate="
				+ pubDate + ", rent=" + rent + ", rentDate=" + rentDate + ", memberId=" + memberId + "]";
	}
	
	
	
	
	

}
