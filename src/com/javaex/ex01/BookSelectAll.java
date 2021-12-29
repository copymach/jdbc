package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelectAll {

	public BookSelectAll() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
//		책 + 작가 모든 정보를 보여준다
		


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
			query += " select  author.author_id id, ";
			query += "			author_name, ";
			query += "			author_desc, ";
			query += "			book_id, ";
			query += "			title, ";
			query += "			pubs, ";
			query += "			pub_date ";
			query += " from author, book ";
			query += " where book.author_id = author.author_id ";
			
			
			System.out.println(query);
			
//			문자열을 쿼리로 만들자
			pstmt = conn.prepareStatement(query);
			
//			실행
			rs = pstmt.executeQuery();
			
			
		// 4.결과처리
//			결과를 한줄씩 뽑아오기
			
			
			while (rs.next()) {
				
//				author.author_id 써먹어보고싶은데 안된다 -> SQL에서 별명 지어주고 별명 불러오는 것으로 해결
				int authorId = rs.getInt("id"); 
				String author_name = rs.getString("author_name");
				String author_desc = rs.getString("author_desc");
				int bookId = rs.getInt(1);
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pubDate = rs.getString("pub_date");
				
				
//				int authorId = rs.getInt(1);
//				String author_name = rs.getString(2);
//				String author_desc = rs.getString(3);
//				int bookId = rs.getInt(4);
//				String title = rs.getString(5);
//				String pubs = rs.getString(6);
//				String pubDate = rs.getString(7);
				
				System.out.println(authorId+", "+author_name+", "+author_desc+", "+bookId+", "+title+", "+pubs+", "+pubDate);
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
