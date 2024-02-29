package lee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InRegDAO {

	//select
	public List selectPd(PdDTO pdDTO) {
		List list = new ArrayList();
		// DB 접속
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "scott_jal";
		String password = "jal123456";
		
		try {
			// 드라이버 로딩
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");

			// DB 접속
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");
			
			// SQL 만들기
			String query = "";
			query += " select";
			query += " pnum, pname, psize, punit";
			query += " from";
			query += " pd_list";
			
			System.out.println("query : " + query);
			// SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);
			
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			while (rs.next()) {
				String pnum = rs.getString("pnum");
				String pname = rs.getString("pname");
				String psize = rs.getString("psize");
				String punit = rs.getString("punit");
				
				// 콘솔 출력
				System.out.println("pnum : " + pnum);
				System.out.println("pname : " + pname);
				System.out.println("psize : " + psize);
				System.out.println("punit : " + punit);
				System.out.println("-----------------------------");
				
				PdDTO dto = new PdDTO();
				dto.setPnum(pnum);
				dto.setPname(pname);
				dto.setPsize(psize);
				dto.setPunit(punit);
				list.add(dto);
			}
			rs.close();
			ps.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
	
	//update
	//insert
	//delete
}
