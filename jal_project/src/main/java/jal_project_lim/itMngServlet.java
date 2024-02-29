package jal_project_lim;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lee.InRegDAO;
import lee.PdDTO;



@WebServlet("/itMngServlet")
public class itMngServlet extends HttpServlet {
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
			query += " SELECT pname, sct, pnum, wzone, pday, psize";
			query += " FROM pd_list";
			query += " FULL OUTER JOIN small_cat ON pd_list.scid = small_cat.scid";

			System.out.println("query : " + query);
			
			// SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);
			
			// SQL 실행, ResultSet으로 결과 확보
			ResultSet rs = ps.executeQuery();

			while( rs.next() ) {
				// getxxx -> 전달인자로 컬럼명, 대소문자 구분 x
				String pname = rs.getString("pname");
				String sct = rs.getString("sct");
				String pnum = rs.getString("pnum");
				String wzone = rs.getString("wzone");
				String pday = rs.getString("pday");
				String psize = rs.getString("psize");
			
				
				// 브라우저 출력
				PrintWriter out = response.getWriter();
				out.println("<div>pnum : " + pnum + "</div>");
				out.println("<div>sct : " + sct + "</div>");
				out.println("<div>pname : " + pname + "</div>");
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
		
		// DB 담당에게 전달
				
		itMngDAO itmngDAO = new itMngDAO();
		
		itMngDTO itmngDTO = new itMngDTO();
		
		itmngDTO.setPnum(itmngDTO.getPnum());
		itmngDTO.setPname(itmngDTO.getPname());
		itmngDTO.setPsize(itmngDTO.getPsize());
		itmngDTO.setWzone(itmngDTO.getWzone());
		itmngDTO.setSct(itmngDTO.getSct());
		itmngDTO.setPday(itmngDTO.getPday());
		
		// 결과 받기
		List list = itMngDAO.selectMng(itmngDTO);
//				System.out.println(list);
//				System.out.println(((PdDTO)list.get(0)).getPnum());
		
		request.setAttribute("list", list);
		
		// view 담당에게 전달
		request.getRequestDispatcher("/jsp/itemMng.jsp").forward(request, response);
	}

		
	}

