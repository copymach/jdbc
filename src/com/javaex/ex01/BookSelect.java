package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelect {

	public BookSelect() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
//		책데이터 가져오기
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "1234");
			
		// 3. SQL문 준비 / 바인딩 / 실행
			
			String query = "";
			query += " select  book_id, ";
			query += "			title,";
			query += "			pubs,";
			query += "			pub_date,";
			query += "			author_id ";
			query += " from book ";
			System.out.println(query);
			
//			문자열을 쿼리로 만들자
			pstmt = conn.prepareStatement(query);
			
//			실행
			rs = pstmt.executeQuery();
			
			
		// 4.결과처리
//			결과를 한줄씩 뽑아오기
			
			while (rs.next()) {
				int bookId = rs.getInt(1);
				String Title = rs.getString(2);
				String Pubs = rs.getString(3);
				String PubDate = rs.getString(4);
				String AuthorID = rs.getString(5);
				
				/*
				int bookId = rs.getInt("book_id");
				String Title = rs.getString("title");
				String Pubs = rs.getString("pubs");
				String PubDate = rs.getString("pub_date");
				String AuthorID = rs.getString("author_id");
				*/
				System.out.println(bookId+", "+Title+", "+Pubs+", "+PubDate+", "+AuthorID);
			}
			
			
			
		} catch (ClassNotFoundException e) {
		System. out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		System. out.println("error:" + e);
		} finally {
		// 5. 자원정리
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
			System. out.println("error:" + e);
			}
		}
		
	}

}
