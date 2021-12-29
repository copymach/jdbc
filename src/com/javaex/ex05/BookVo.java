package com.javaex.ex05;

public class BookVo {

//필드 - 가져올 테이블 정보하고 일치하지 않는다 만들때 고민해볼것  
	private int bookId;
	private String title;
	private String pubs;
	private String pubdate;
	private int authorId;
	private String authorName;
	private String authorDesc;

//생성자 컨스트럭터
	public BookVo() { // 기본 생성자
	}


//	생성자1
	public BookVo(String title, String pubs, String pubdate, int authorId) {
		this.title = title;
		this.pubs = pubs;
		this.pubdate = pubdate;
		this.authorId = authorId;
	}

	/*
// 생성자2 모든 내용 포함
	public BookVo(int bookId, String title, String pubs, String pubdate, int authorId, String authorName,
			String authorDesc) {
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pubdate = pubdate;
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}

// 생성자3 int 부분을 제외
	public BookVo(String title, String pubs, String pubdate, String authorName, String authorDesc) {
		this.title = title;
		this.pubs = pubs;
		this.pubdate = pubdate;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}
*/
	
//메소드 gs
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

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
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

//메소드 일반
	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", title=" + title + ", pubs=" + pubs + ", pubdate=" + pubdate
				+ ", authorId=" + authorId + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
	}

}
