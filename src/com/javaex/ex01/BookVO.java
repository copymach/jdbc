package com.javaex.ex01;

public class BookVO {

//필드
private int book_id;
private String title;
private String pubs;
private String pub_date;
private int authorId;


public BookVO() {
	super();
}


public BookVO(int book_id, String title, String pubs, String pub_date, int authorId) {
	super();
	this.book_id = book_id;
	this.title = title;
	this.pubs = pubs;
	this.pub_date = pub_date;
	this.authorId = authorId;
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


public int getAuthorId() {
	return authorId;
}


public void setAuthorId(int authorId) {
	this.authorId = authorId;
}


@Override
public String toString() {
	return "BookVO [book_id=" + book_id + ", title=" + title + ", pubs=" + pubs + ", pub_date=" + pub_date
			+ ", authorId=" + authorId + "]";
}





	
}
