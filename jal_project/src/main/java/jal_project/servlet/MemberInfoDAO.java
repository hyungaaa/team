package jal_project.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/memberInfoDAO")
public class MemberInfoDAO extends HttpServlet {
	
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
		
		
	// 입력한 사원번호와 일치하는 사원번호가 있는지 확인 & 아이디 유무까지 체크
		public Boolean checkUnumUuid(MemberInfoDTO memberInfoDTO) {
			
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
				query += " from member_info";
				query += " where lower(unum) like '%' || lower(?) || '%'";
				query += " and uuid is NULL";

				System.out.println("query : " + query);

				// SQL 실행 준비
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, memberInfoDTO.getUnum());
				
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

}
