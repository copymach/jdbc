package com.javaex.ex03;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {

		List<AuthorVo> list;
		AuthorDao authorDao = new AuthorDao();
		
		AuthorVo vo01 = new AuthorVo("영심이", "말괄량이");
		authorDao.authorInsert(vo01);
		
		AuthorVo vo02 = new AuthorVo ("피카츄", "전기 쥐");
		authorDao.authorInsert(vo02);
		
		AuthorVo vo03 = new AuthorVo ("손오공", "원숭이");
		authorDao.authorInsert(vo03);
		
		System.out.println("----------------------");
		list = authorDao.authorSelect();
		
		for (int i=0; i<list.size(); i++) {
			AuthorVo vo = list.get(i);
			System.out.println(vo.getAuthorId() +", "+ vo.getAuthorName() +", "+ vo.getAuthorDesc());
		}
		
		System.out.println("----------------------");
		
		
//		작가수정
		
		AuthorVo authorVo = new AuthorVo(41, "박경리(수정)",  "경상남동 통영(수정)"); 
		authorDao.authorUpdate(authorVo);
		
		System.out.println("----------------------------------");
		list = authorDao.authorSelect();
		for(int i=0; i<list.size(); i++) {
			AuthorVo vo = list.get(i);
			System.out.println(vo.getAuthorId() + ", " + vo.getAuthorName() + ", " + vo.getAuthorDesc());
		}
		System.out.println("----------------------------------");
		
		

//		작가삭제
//		authorDao.authorDelete(1, "이효리");
		
				authorDao.authorDelete(2);
				
				System.out.println("----------------------------------");
				list = authorDao.authorSelect();
				for(int i=0; i<list.size(); i++) {
					AuthorVo vo = list.get(i);
					System.out.println(vo.getAuthorId() + ", " + vo.getAuthorName() + ", " + vo.getAuthorDesc());
				}
				System.out.println("----------------------------------");
		
		
		
	}

}
