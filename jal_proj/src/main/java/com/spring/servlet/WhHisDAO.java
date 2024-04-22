package com.spring.servlet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WhHisDAO {

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
	
	
	// 데이터 조회 메서드 (최근 일주일)
    public List<WhHisDTO> getWhHisList() {
        List<WhHisDTO> whHisList = new ArrayList<WhHisDTO>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConn();
            String sql = "SELECT * FROM wh_his WHERE wdate >= (SELECT MAX(wdate) FROM wh_his) - 7";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int wid = rs.getInt("wid");
                String wzone = rs.getString("wzone");
                Date wdate = rs.getDate("wdate");
                int wcnt = rs.getInt("wcnt");
                int wpercent = rs.getInt("wpercent");
                
                WhHisDTO whHisDTO = new WhHisDTO(wid, wzone, wdate, wcnt, wpercent);
                whHisList.add(whHisDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return whHisList;
    }
	
	
	
	
}