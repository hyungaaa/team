package jal_project_lim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class itMngDAO {

	//select
	public List selectMng(itMngDTO itmngDTO) {
		List list = new ArrayList();
		
		try {
			
			// DB접속
			Connection con = getConn();
			
			// SQL 만들기
			String query = "";
			query += " SELECT pname, sct, pnum, wzone, pday, psize";
			query += " FROM pd_list";
			query += " FULL OUTER JOIN small_cat ON pd_list.scid = small_cat.scid";
			
			System.out.println("query : " + query);
			
			//SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);
				
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			while (rs.next()) {
				String pnum = rs.getString("pnum");
				String pname = rs.getString("pname");
				String psize = rs.getString("psize");
				String wzone = rs.getString("wzone");
				String sct = rs.getString("sct");
				String pday = rs.getString("pday");
							
				// 콘솔 출력
				System.out.println("pnum : " + pnum);
				System.out.println("pname : " + pname);
				System.out.println("psize : " + psize);
				System.out.println("wzone : " + wzone);
				System.out.println("sct : " + sct);
				System.out.println("pday : " + pday);
				System.out.println("-----------------------------");
							
				itMngDTO mng = new itMngDTO();
				mng.setPnum(pnum);
				mng.setPname(pname);
				mng.setPsize(psize);
				mng.setWzone(wzone);
				mng.setSct(sct);
				mng.setPday(pday);
				list.add(mng);
			}
			rs.close();
			ps.close();
			con.close();	
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	private Connection getConn() {
		// DB 접속
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "scott_jal";
		String password = "jal123456";

		Connection con = null;
		try {
			// 드라이버 로딩
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
	
}
