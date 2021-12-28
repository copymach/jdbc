package com.javaex.ex01;

public class AuthorVO {

	
//필드
private int authorId;
private String authorName;
private String authorDesc;


//생성자 컨스트럭터
public AuthorVO() {
	super();
}

public AuthorVO(int authorId, String authorName, String authorDesc) {
	super();
	this.authorId = authorId;
	this.authorName = authorName;
	this.authorDesc = authorDesc;
}



//메소드

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



//메소드일반


@Override
public String toString() {
	return "AuthorVO [authorId=" + authorId + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
}





}
