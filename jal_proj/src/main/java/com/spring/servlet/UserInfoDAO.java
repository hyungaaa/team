package com.spring.servlet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class UserInfoDAO {
	
	
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
		

	// 로그인 (아이디 일치하는 열 조회하고, 비밀번호 일치여부 확인)
	public void loginID(UserInfoDTO userInfoDTO, HttpServletRequest request, HttpServletResponse response) {

		// DB 접속
		Connection con = getConn();
		// 연결 실패 시 
		if(con==null) {
			System.out.println("DB 연결에 실패하였습니다. 연결을 다시 시도하세요.");
		}
		
		try {

			// SQL 작성
			String query = "";
			query += " select";
			query += " *";
			query += " from";		
			query += " user_info";
			query += " where lower(uuid) like '%' || lower(?) || '%'";
			System.out.println("query : "+ query);
			
			// SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, userInfoDTO.getUuid());
			
			// SQL 실행, ResultSet으로 결과 확보
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				// 일치 여부
				if(userInfoDTO.getUpass().equals(rs.getString("upass"))) {
					System.out.println("login-pass");
					
					//세션 생성
					HttpSession session = request.getSession();
					session.setAttribute("isLogon", "ok");
					
					
					// 유저 이름, 마스터 여부 세션에 저장
					String uname = (String) rs.getString("uname");
					String ccode = (String) rs.getString("ccode");
					int umaster = (int) rs.getInt("umaster");
					
					session.setAttribute("uname", uname);
					session.setAttribute("umaster", umaster);
					
					
					// 센터코드로 센터명 검색
					query = "";
					query += " select";
					query += " cname";
					query += " from";		
					query += " center_list";
					query += " where lower(ccode) like '%' || lower(?) || '%'";
					
					PreparedStatement ps2 = con.prepareStatement(query);
					ps2.setString(1, ccode);
					ResultSet rs2 = ps2.executeQuery();
					
					// 센터명 세션에 저장
					if(rs2.next()) {
						String cname = (String) rs2.getString("cname");
						session.setAttribute("cname", cname);
					}
					
					
					rs2.close();
					ps2.close();
					
					//로그인 성공 시 대시보드로 리디렉트
					response.sendRedirect("dashboard");

					
				} else{
					System.out.println("fail");
					
					//로그인 실패 시 로그인페이지로 리디렉트
					response.sendRedirect("login");

				}
			}
			
			// 연결 닫아주기
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
    // ID 생성 시 중복확인 (uuid 조회)
	public boolean checkIdExists(UserInfoDTO userInfoDTO) {
		
		// DB 접속
		Connection con = getConn();
		// 연결 실패 시 
		if(con==null) {
			System.out.println("DB 연결에 실패하였습니다. 연결을 다시 시도하세요.");
		}
				
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user_info WHERE uuid = ?");
            ps.setString(1, userInfoDTO.getUuid());
            ResultSet rs = ps.executeQuery();
            boolean isDuplicate = rs.next();
            
            //연결 종료
            rs.close();
            ps.close();
            con.close();
            
            return isDuplicate;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	
    // 패스워드 초기화 (upass 랜덤 String로 업데이트)
	public void resetUpass(UserInfoDTO userInfoDTO) {
		
		// DB 접속
		Connection con = getConn();
		// 연결 실패 시 
		if(con==null) {
			System.out.println("DB 연결에 실패하였습니다. 연결을 다시 시도하세요.");
		}
				
        try {

			// 유저 아이디로 레코드 검색하여 임시 비밀번호 부여
			String query = "";
			query += " UPDATE user_info";
			query += " SET upass = dbms_random.string('X',8)";
			query += " WHERE lower(uuid) like '%' || lower(?) || '%'";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, userInfoDTO.getUuid());
			ResultSet rs = ps.executeQuery();
			
			// 센터명 세션에 저장
			if(rs.next()) {
				System.out.println("비밀번호를 초기화하였습니다.");
			}
			
			rs.close();
			ps.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }	
	

}
