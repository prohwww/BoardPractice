package com.test.board;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//JAVA DOC 주석
/**
 * 
 * @author 전혜원
 * 오라클 연결 클래스 입니다.
 * 
 */
public class DBUtil {

	private Connection conn = null;
	
	/**
	 * 서버에 연결합니다.
	 * @return 연결 객체를 반환합니다.
	 */
	public Connection open() {
		
		String url = "jdbc:oracle:thin:@localhost:49160:xe";
//		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "system";
		String pw = "oracle";

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, id, pw);
			
			return conn; //접속 성공
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null; //접속 실패
		
	}// open()

	/**
	 * 서버에 연결합니다.
	 * @param host 서버 주소
	 * @param id 계정명
	 * @param pw 비밀번호
	 * @return 연결 객체를 반환합니다.
	 */
	public Connection open(String host, String id, String pw) {

		String url = "jdbc:oracle:thin:@" + host + ":1521:xe";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, id, pw);
			
			return conn; // 접속 성공

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null; // 접속 실패

	}// open()
	
	/**
	 * 연결을 종료합니다.
	 */
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//close()
	
}