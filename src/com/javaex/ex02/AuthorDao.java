package com.javaex.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDao {

//생성자
	public AuthorDao() { // 생략가능
	}

//메소드gs

//메소드 일반

//작가추가
	public void authorInsert(String authorName, String authorDesc) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
//	ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "1234");
			// 3. SQL문 준비 / 바인딩 / 실행

			// 3. SQL문 준비 / 바인딩 / 실행
//		String query = "insert into"; 쿼리문 만들기 -> ?주의
			String query = "";

//		query = query + "insert into author"; 
//		tip 쿼리 에러를 피하기 위해 ""사이를 띄워서 공백을 넣어준다
			query += " insert into author ";

//		query = query + "values (seq_author_id.nextval, '이문열', '경북 영양')";
			query += " values(seq_author_id.nextval, ?, ? ) ";
			System.out.println(query);

//		문자열 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);

//		바인딩		
			pstmt.setString(1, authorName); // 첫번쨰 물음표의
			pstmt.setString(2, authorDesc);// 두번째 물음표의 데이터

//		실행
			int count = pstmt.executeUpdate(); // 쿼리문 실행
			System.out.println(count + "건이 저장되었습니다. \t (작가) ");

			// 4.결과처리

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
//		if (rs != null) {
//		rs.close();
//		}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}

	} // 작가 추가 끝

//작가 삭제
	public void authorDelete(int index) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
//	ResultSet rs = null;
		try {

			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "1234");
			System.out.println("접속 성공");
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " delete from author ";
			query += " where author_id = ? ";

			System.out.println(query);

//		문자열을 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);

//		바인딩
			pstmt.setInt(1, index);

//		실행
			int count = pstmt.executeUpdate();

			System.out.println(index + "번 작가, " + count + "건이 삭제되었습니다.");

			// 4.결과처리
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}

	} // 작가 삭제 끝

//	작가 수정 시작
	public void authorUpdate(int index, String authorName, String authorDesc) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
//		ResultSet rs = null; 수정클래스라서 안쓸거임

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "1234");
			System.out.println("접속 성공");

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " update author ";
			query += " set author_name = ?, ";
			query += "     author_desc = ? ";
			query += " where author_id = ? ";

			System.out.println(query);

//			문자열을 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);

//			바인딩
			pstmt.setString(1, authorName);
			pstmt.setString(2, authorDesc);
			pstmt.setInt(3, index);

//			실행
			int count = pstmt.executeUpdate();
//			int count = pstmt.executeUpdate(query); 쿼리값을 넣을 필요가 없다

			System.out.println(index + "번 데이터, " + count + "건이 수정 되었습니다.");

			// 4.결과처리

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}

	} // 작가 수정 끝

}
