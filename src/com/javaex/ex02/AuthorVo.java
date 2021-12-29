package com.javaex.ex02;

// ctrl shift f 자동정렬 단축키

public class AuthorVo {

	
//	필드
	private int authorId;
	private String authorName;
	private String authorDesc;

	
	
//	생성자 컨스트럭터
	public AuthorVo() {
		super();
	}

	public AuthorVo(int authorId, String authorName, String authorDesc) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}

	
//메소드 gs
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

//	메소드 일반

	@Override
	public String toString() {
		return "AuthorVo [authorId=" + authorId + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
	}

}
