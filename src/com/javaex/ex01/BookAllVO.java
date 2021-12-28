package com.javaex.ex01;

public class BookAllVO {

	private int authorId;
	private String authorName;
	private String authorDesc;

	private int book_id;
	private String title;
	private String pubs;
	private String pub_date;

	
	public BookAllVO() {
		super();
	}


	public BookAllVO(int authorId, String authorName, String authorDesc, int book_id, String title, String pubs,
			String pub_date) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
		this.book_id = book_id;
		this.title = title;
		this.pubs = pubs;
		this.pub_date = pub_date;
	}


	public int getAuthorId() {
		return authorId;
	}


	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}


	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	public String getAuthorDesc() {
		return authorDesc;
	}


	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}


	public int getBook_id() {
		return book_id;
	}


	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getPubs() {
		return pubs;
	}


	public void setPubs(String pubs) {
		this.pubs = pubs;
	}


	public String getPub_date() {
		return pub_date;
	}


	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}


	@Override
	public String toString() {
		return "BookAllVO [authorId=" + authorId + ", authorName=" + authorName + ", authorDesc=" + authorDesc
				+ ", book_id=" + book_id + ", title=" + title + ", pubs=" + pubs + ", pub_date=" + pub_date + "]";
	}


	
	
	
	
	

}
