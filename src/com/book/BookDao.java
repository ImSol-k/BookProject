package com.book;

public class BookDao {
	
	private int bookId;
	private String title;
	private String author;
	private String pubs;
	private String pubDate;
	private String memberId;
	
	
	public BookDao(int bookId, String title, String author, String pubs, String pubDate, String memberId) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.pubs = pubs;
		this.pubDate = pubDate;
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
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	
	@Override
	public String toString() {
		return "BookDao [bookId=" + bookId + ", title=" + title + ", author=" + author + ", pubs=" + pubs + ", pubDate="
				+ pubDate + ", memberId=" + memberId + "]";
	}

}
