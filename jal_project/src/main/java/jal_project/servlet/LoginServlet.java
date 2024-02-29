package jal_project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("세팅 시작");
		
		controller(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	protected void controller(HttpServletRequest request, HttpServletResponse response) {

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
			

			String uid = request.getParameter("userid");
			String pass = request.getParameter("pw");
			// SQL 작성
			
			String query = "";
			query += " select";
			query += " *";
			query += " from";		
			query += " user_info";
			query += " where lower(uuid) like '%' || lower(?) || '%'";
			// select*fromemp
			System.out.println("query : "+ query);
			
			// SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, uid);
			
			// SQL 실행, ResultSet으로 결과 확보
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				// 일치 여부
				if(pass.equals(rs.getString("upass"))) {
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
					response.sendRedirect("login.do");

				}
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	protected void forward(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			String url = "dashboard";
			
			RequestDispatcher dispatch = request.getRequestDispatcher(url);
		
			dispatch.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
