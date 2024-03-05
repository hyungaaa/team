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

	//DB 연결
	private Connection getConn() {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "scott_jal";
		String password = "jal123456";
		
		Connection con = null;
		
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			// DB 접속
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	// select - 입력한 사원번호와 일치하는 사원번호가 있는지 확인
	public Boolean checkUnum(UserInfoDTO userInfoDTO) {
		
		// 사원번호 일치확인 여부
		Boolean boolean1 = false;
		
		// DB 접속
		Connection con = getConn();
		// 연결 실패 시 
		if(con==null) {
			System.out.println("DB 연결에 실패하였습니다. 연결을 다시 시도하세요.");
		}

		try {

			// SQL 만들기
			String query = "";
			query += " select";
			query += " *";
			query += " from user_info";
			query += " where lower(unum) like '%' || lower(?) || '%'";

			System.out.println("query : " + query);

			// SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, userInfoDTO.getUnum());
			
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();

			// 일치하는 사원번호가 있다면 true
			boolean1 = rs.next();

			// 연결 닫아주기
			rs.close();
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return boolean1;

	}
		
	
	// select - 입력한 이메일과 일치하는 사원이 있는지 확인
		public Boolean checkUemail(UserInfoDTO userInfoDTO) {
			
			// 사원번호 일치확인 여부
			Boolean boolean1 = false;
			
			// DB 접속
			Connection con = getConn();
			// 연결 실패 시 
			if(con==null) {
				System.out.println("DB 연결에 실패하였습니다. 연결을 다시 시도하세요.");
			}

			try {

				// SQL 만들기
				String query = "";
				query += " select";
				query += " *";
				query += " from user_info";
				query += " where lower(uemail) like '%' || lower(?) || '%'";

				System.out.println("query : " + query);

				// SQL 실행 준비
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, userInfoDTO.getUemail());
				
				// SQL 실행 및 결과 확보
				ResultSet rs = ps.executeQuery();

				// 일치하는 사원이 있다면 true
				boolean1 = rs.next();

				// 연결 닫아주기
				rs.close();
				ps.close();
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return boolean1;

		}
		
		

	
	// 요청 건 req_list 테이블에 추가
	public void insertReqList(UserInfoDTO userInfoDTO, int rct) {

		// DB 접속
		Connection con = getConn();
		// 연결 실패 시 
		if(con==null) {
			System.out.println("DB 연결에 실패하였습니다. 연결을 다시 시도하세요.");
		}

		try {

			// SQL 만들기
			String query = "";
			query += " insert into req_list";
			query += " values";
			query += " ((select COALESCE(MAX(rid) + 1, 1) from req_list), ?, ?, ?)";

			System.out.println("query : " + query);

			// SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);
			
			// 사용자등록 : 1 , 비밀번호초기화 : 2
			String rct1 = (rct ==1)? "사용자등록": "비밀번호초기화";
			ps.setString(1, rct1);
			ps.setString(2, userInfoDTO.getUemail());
			ps.setString(3, userInfoDTO.getUuid());
			
			// SQL 실행 및 결과 확보
	        ps.executeUpdate(); // executeQuery() 대신 executeUpdate()로 변경
	        ps.close();
	        

	        // 변경 내용을 영구적으로 저장하고 데이터베이스에 반영
	        // 자동커밋이 설정되어서 수동커밋 비활성화
	        // con.commit(); 

	        // 연결 닫아주기
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
				
	}	

}
