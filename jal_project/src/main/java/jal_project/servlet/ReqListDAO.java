package jal_project.servlet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class ReqListDAO {

	// select
	public Boolean checkUnum(String unum) {
		Boolean boolean1 = false;
		
		// DB 접속
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "scott_jal";
		String password = "jal123456";

		try {
			// 드라이버 로딩
			// Class.forName : String 변수로 class 생성
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			// DB 접속
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");

			
			// SQL 만들기
			String query = "";
			query += " select";
			query += " *";
			query += " from user_info";
			query += " where lower(unum) like '%' || lower(?) || '%'";

			System.out.println("query : " + query);

			// SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, unum);
			

			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();

			// 결과 활용
			if (rs.next()) {
				// 일치하는 사원번호가 있다면
				// 요청 추가
				boolean1 = true;
			}

			rs.close();
			ps.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return boolean1;

	}

	
	public void insertReqList(String uuid, String uemail, int rct) {

		// DB 접속
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "scott_jal";
		String password = "jal123456";

		try {
			// 드라이버 로딩
			// Class.forName : String 변수로 class 생성
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			// DB 접속
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");

			
			// SQL 만들기
			String query = "";
			query += " insert into req_list";
			query += " values";
			query += " ((select MAX(rid) + 1 from req_list), ?, ?, ?)";

			System.out.println("query : " + query);

			// SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, uuid);
			String rct1 = (rct == 1)? "사용자등록" : "";
			ps.setString(2, rct1);
			ps.setString(3, uemail);
			

			// SQL 실행 및 결과 확보
	        ps.executeUpdate(); // executeQuery() 대신 executeUpdate()로 변경

	        // 변경 내용을 영구적으로 저장하고 데이터베이스에 반영
	        // 자동커밋이 설정되어서 수동커밋 비활성화
	        // con.commit(); 

			ps.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();

		}
				
	}	

}
