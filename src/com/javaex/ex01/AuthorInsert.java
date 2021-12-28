package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorInsert {

	public AuthorInsert() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
//		ResultSet rs = null;  인서트 할거라서 이번엔 이거 안쓸꺼임
		
		
		try {
		// 1. JDBC 드라이버 (Oracle) 로딩 - 다른db라면 OracleDriver 이름도 달라짐 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		// 2. Connection 얻어오기 -localhost 자리 ip 주소입력 / webdb 자리 id pw
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "1234");
			System.out.println("접속 성공");
			
		// 3. SQL문 준비 / 바인딩 / 실행
//			String query = "insert into"; 쿼리문 만들기 -> ?주의
			String query = "";
			
//			query = query + "insert into author"; 
//			tip 쿼리 에러를 피하기 위해 ""사이를 띄워서 공백을 넣어준다
			query += " insert into author ";
			
//			query = query + "values (seq_author_id.nextval, '이문열', '경북 영양')";
		    query += " values(seq_author_id.nextval, ?, ? ) " ;
		    System.out.println(query);
		    
			
//			문자열 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);
					
			
//			바인딩		
			pstmt.setString(1, "이문열");  // 첫번쨰 물음표의 		
			pstmt.setString(2, "경북 영양");//두번째 물음표의 데이터
			
//			실행
			int count = pstmt.executeUpdate(); //쿼리문 실행
			System.out.println( count + "건이 저장되었습니다.");
			
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
