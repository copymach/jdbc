package com.javaex.ex05;

import java.util.List;

import com.javaex.ex03.AuthorDao;
import com.javaex.ex03.AuthorVo;

public class BookApp {

	public static void main(String[] args) {
//dao 만들기 authorVo사용하기, 공통변수빼기

		List<BookVo> list;
		BookDao bookDao = new BookDao();
		
//		책 입력하기 '삼국지', '민음사', '2002-03-01', 1);
		BookVo bk01 = new BookVo("군주론", "마키아벨리즘출판", "1002-12-19", 1);
		bookDao.bookInsert(bk01);

		
		
		
		
		
//		북 삭제 하기 미완성
//		authorDao.authorDelete(1, "이효리");
		bookDao.bookDelete(0); 
		
		System.out.println("----------------------------------");
		list = bookDao.BookSelect();
		for(int i=0; i<list.size(); i++) {
			BookVo vo = list.get(i);
			System.out.println(vo.getBookId()+ ", " + vo.getTitle() +", "+vo.getAuthorId()+", "+ vo.getAuthorName() + ", " + vo.getAuthorDesc());
		}
		System.out.println("----------------------------------");

		
		
	}

}
