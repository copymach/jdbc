package com.javaex.ex02;

public class AuthorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AuthorDao authorDao = new AuthorDao();

//		작가등록
		authorDao.authorInsert("이문열", "경북 영양");
	
		
//		작가추가
		authorDao.authorInsert("박경리", "경상남도 통영");

		
//		작가수정
		authorDao.authorUpdate(14, "둘리(수정)", "아기공룡");

		
//		작가삭제
		authorDao.authorDelete(22);

		
		
		
		
		
		
		
		
		
		
	}

}
