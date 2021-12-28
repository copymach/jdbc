package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookInsert {

	public BookInsert() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
		// 1. JDBC 드라이버 (Oracle) 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. Connection 얻어오기
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
					conn = DriverManager.getConnection(url, "webdb", "1234");
					System.out.println("접속 성공");
					

		// 3. SQL문 준비 / 바인딩 / 실행
					String query = "";
					
					query += " INSERT INTO book ";
					query += " VALUES (seq_book_id.nextval, ?, ?, ?, ?) ";
					
					System.out.println(query);
					
//					문자열을 쿼리문으로 만들기
					pstmt = conn.prepareStatement(query);
					
//					바인딩
					pstmt.setString(1, "우리들의 일그러진 영웅");
					pstmt.setString(2, "다림");
					pstmt.setString(3, "1998/02/22");
					pstmt.setInt(4, 2);
					
//					실행
					int count = pstmt.executeUpdate();
					
					System.out.println(count +"건이 추가되었습니다.");
					

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
