package com.javaex.ex02;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {

		List<AuthorVo> list;
		
		AuthorDao authorDao = new AuthorDao();
		// 레퍼런스 타입 / 레퍼런스 변수 = new 인스턴스 생성 키워드 / 생성자();

//		작가등록
		authorDao.authorInsert("이문열", "경북 영양");

//		작가등록2
		authorDao.authorInsert("박경리", "경상남도 통영");

//		작가 리스트 출력 
		list = authorDao.authorSelect();
		for (int i = 0; i < list.size(); i++) {
			AuthorVo authorVo = list.get(i);
			System.out.println(
					authorVo.getAuthorId() + ", " + authorVo.getAuthorName() + ", " + authorVo.getAuthorDesc());
		}
		System.out.println("---------------------------------------");

		
//		작가수정
		authorDao.authorUpdate(14, "둘리(수정)", "아기공룡");

//		작가 리스트 출력 
		list = authorDao.authorSelect();
		for (int i = 0; i < list.size(); i++) {
			AuthorVo authorVo = list.get(i);
			System.out.println(
					authorVo.getAuthorId() + ", " + authorVo.getAuthorName() + ", " + authorVo.getAuthorDesc());
		}
		System.out.println("---------------------------------------");

		
//		작가삭제
//		authorDao.authorDelete(22);

	}

}
