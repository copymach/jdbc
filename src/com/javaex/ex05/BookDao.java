package com.javaex.ex05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.ex04.AuthorVo;


//Dao만들기, AuthorVo사용하기, 공통변수 빼기+메소드


public class BookDao {

//	필드
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "webdb";
	private String pw = "1234";

//	생성자
	public BookDao() {
	}

//	메소드gs

//	메소드일반
	private void getConnection() {

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	} // getConn 종료

	private void close() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	} // close 종료

//	북 추가	
	public void bookInsert(BookVo bookVo) {

		getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
//		String query = "insert into"; 쿼리문 만들기 -> ?주의
			String query = "";

//		query = query + "insert into author"; 
//		tip 쿼리 에러를 피하기 위해 ""사이를 띄워서 공백을 넣어준다
			query += " insert into book ";

//		query = query + "VALUES (seq_book_id.nextval, '삼국지', '민음사', '2002-03-01', 1);
			query += " values(seq_author_id.nextval, ?, ?, ?, ?) ";
			System.out.println(query);

//		문자열 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);

//		바인딩		
			pstmt.setString(1, bookVo.getTitle()); // 첫번쨰 책제목
			pstmt.setString(2, bookVo.getPubs());// 두번째 물음표 출판사
			pstmt.setString(3, bookVo.getPubdate()); // 출판일
			pstmt.setInt(4, bookVo.getAuthorId()); // 저자ID

//		실행
			int count = pstmt.executeUpdate(); // 쿼리문 실행
//		4.결과처리
			System.out.println(count + "건이 저장되었습니다. \t (작가) ");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		// 5. 자원정리
		close();

	} // 북 추가 종료

	
	// 북 삭제
	public void bookDelete(int index) {

		getConnection();
		
		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " delete from book ";
			query += " where book_id = ? ";

			System.out.println(query);

//			문자열을 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);

//			바인딩
			pstmt.setInt(1, index);

//			실행
			int count = pstmt.executeUpdate();

//			4.결과처리
			System.out.println(index + "번 책, " + count + "건이 삭제되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		
//		5.자원 닫기
		close();

	} // 북 삭제 종료

	
	
//		북 수정 시작
	public void BookUpdate(BookVo bookVo) {

		getConnection();
		
		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " update book ";
			query += " set title = ?, ";
			query += "     pubs = ? ";
			query += "     pub_date = ? ";
			query += " where book_id = ? ";

			System.out.println(query);

//				문자열을 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);

//				바인딩
			pstmt.setString(1, bookVo.getTitle());
			pstmt.setString(2, bookVo.getPubs());
			pstmt.setString(3, bookVo.getPubdate());
			pstmt.setInt(4, bookVo.getBookId());

//				실행
			int count = pstmt.executeUpdate();

			System.out.println(count + "건이 수정 되었습니다.");

			// 4.결과처리

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		
		// 5. 자원정리
		close();
		
	} // 북 수정 끝

	
//		작가 리스트 가져오기
	public List<BookVo> bookSelect() {
//			오라클db의 모든 작가 정보를 가져오는 코드 -> 리스트 출력

		// 리스트 생성
		List<BookVo> bookList = new ArrayList<BookVo>();

		getConnection();
		
		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// 문자열 만들기
			String query = "";
			query += " select  author.author_id aid, "; // author_id as id
			query += "          author_name, ";
			query += "          author_desc, ";
			query += "          book_id bid, "; // 북id
			query += "          title, ";
			query += "          pubs, ";
			query += "          pub_date ";
			query += " from author, book ";
			query += " where book.author_id = author.author_id ";
			System.out.println(query);

			// 문자열 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);

			// 바인딩--> 생략 ( ? 없음)

			// 실행
			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {

				int bookId = rs.getInt("bid"); // 컬럼명이 id로 변경되었기 때문에
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pubdate = rs.getString("pub_date");
				int authorId = rs.getInt("aid");
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");
				System.out.println(bookId+", "+title+", "+pubs+", "+pubdate+"\t"+authorId+", "+authorName+", "+authorDesc);

//		               int authorId= rs.getInt(1);
//		               String authorName= rs.getString(2);
//		               String authorDesc= rs.getString(3);

//				BookVo vo = new BookVo(bookId, title, pubs, pubdate);

				// System.out.println(authorId+"\t"+authorName+"\t"+authorDesc);
			}

			// 출력

			for (int i=0; i<bookList.size(); i++) {
				BookVo bookVo = bookList.get(i);
				System.out.println(
						bookVo.getAuthorId() + ", " + bookVo.getAuthorName() + ", " + bookVo.getAuthorDesc());
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
			// 5. 자원정리
			close();
		

		return bookList;

	} // 작가 리스트 가져오기 종료

}
