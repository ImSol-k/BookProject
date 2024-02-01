package com.library;

public class BookVo {
	
	private int bookId;
	private String title;
	private String author;
	private String pubs;
	private String pubDate;
	private String state;
	
	
	
	public BookVo() {
		super();
	}
	public BookVo(String title, String pubs) {
		this.title = title;
		this.pubs = pubs;
	}
	public BookVo(String title, String author, String pubs) {
		this.title = title;
		this.author = author;
		this.pubs = pubs;
	}
	public BookVo(String title, String author, String pubs, String pubDate) {
		this.title = title;
		this.author = author;
		this.pubs = pubs;
		this.pubDate = pubDate;
	}
	public BookVo(int bookId, String title, String author, String pubs, String pubDate) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.pubs = pubs;
		this.pubDate = pubDate;
	}
	public BookVo(int bookId, String title, String author, String pubs, String pubDate, String state) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.state = state;
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
	
	
	public void showInfo() {
		System.out.println("번호 : " + bookId + "\t| 제목 : " + title + "\t\t| 작가 : " + author + "\t| 출판사 : " + pubs + "\t| 출판일 : " + pubDate + "\t| 상태 : " + state);
	}
	
	
	@Override
	public String toString() {
		return "[bookId=" + bookId + ", title=" + title + ", author=" + author + ", pubs=" + pubs + ", pubDate="
				+ pubDate + "]";
	}
	
	

}
