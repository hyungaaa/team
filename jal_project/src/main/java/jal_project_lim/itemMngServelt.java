package jal_project_lim;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/itemMng1")
public class itemMngServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		controller(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		controller(request, response);
	}
	
	protected void controller(HttpServletRequest request, HttpServletResponse response) {
		// 한글 깨짐 방지
		try {
			// 들어오는 한글 깨짐 방지
			request.setCharacterEncoding("utf-8");	
			// 내보내는 한글 깨짐 방지
			response.setContentType("text/html; charset=utf-8;");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "scott_jal";
		String password = "jal123456";
		
		try {
			// 드라이버 로딩
			// Class.forName : String 변수로 class 생성
			Class.forName(driver);
			System.out.println("★ Oracle 드라이버 로딩 성공 ★");
			
			// DB 접속
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("★ Connection 생성 성공 ★");
			
			
			// SQL 작성
			String query = "";
			// 무조건 앞에 한 칸 띄워서 작성 " select";
			query += " select";
			query += " pname, scid, pnum, wzone, pday, psize";
			query += " from";
			query += " pd_list";

			System.out.println("query : " + query);
			
			// SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);
			
			// SQL 실행, ResultSet으로 결과 확보
			ResultSet rs = ps.executeQuery();
			// select : executeQuery()
			// -> return : ResultSet
			// 그 외 : executeUpdate()
			// -> return : int 
			// (몇 개가 업데이트, 딜레트 됐는지 나옴) (몇 개의 row가 영향을 받았는지 나옴)
			
			// DB 값 활용
			// -> ResultSet : 모든 줄이 담겨져 있음
			// -> rs.next : 모든 줄이 담겨져 있음
			// -> next() 실행 후 ResultSet에는 다음줄이 담김
			while( rs.next() ) {
				// getxxx -> 전달인자로 컬럼명, 대소문자 구분 x
				String pname = rs.getString("pname");
				String scid = rs.getString("scid");
				String pnum = rs.getString("pnum");
				String wzone = rs.getString("wzone");
				String pday = rs.getString("pday");
				String psize = rs.getString("psize");
				// java.util.Date
				// 자바에서 날짜 사용시 사용 -> 클래스 명이 같이 때문에 
				
				
				// 브라우저 출력
				PrintWriter out = response.getWriter();
				out.println("<div>pnum : " + pnum + "</div>");
				out.println("<div>scid : " + scid + "</div>");
				out.println("<div>pnum : " + pnum + "</div>");
				out.println("<div>wzone : " + wzone + "</div>");
				out.println("<div>pday : " + pday + "</div>");
				out.println("<div>psize : " + psize + "</div>");
				out.println("<hr>");
				
			}
			
			rs.close();
			con.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
