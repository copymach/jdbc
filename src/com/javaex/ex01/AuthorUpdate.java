package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorUpdate {

	public AuthorUpdate() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
			pstmt.setString(1, "김문열"); 
			pstmt.setString(2, "삼국지작가");
			pstmt.setInt(3, 5);
			
			
//			실행
			int count = pstmt.executeUpdate();
//			int count = pstmt.executeUpdate(query); 쿼리값을 넣을 필요가 없다
			
			System.out.println( count +"건이 수정 되었습니다.");
			
			
		// 4.결과처리
			
			
		} catch (ClassNotFoundException e) {
		System. out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		System. out.println("error:" + e);
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
			System. out.println("error:" + e);
		}
		}
		
		
		
	}

}
