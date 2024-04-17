package com.spring.lim;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/itMng")
public class itMngServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		controller(request, response);
	}

	
	itMngDAO itmngDAO = new itMngDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    String[] deleteItems = request.getParameterValues("deleteCheckbox");

	    if (deleteItems != null) {
            // DAO에 트랜잭션으로 삭제를 요청
	    	Connection con = null;
	    	try {
	            // DB 접속
	            con = itMngDAO.getConn();

	            // 트랜잭션 시작
	            con.setAutoCommit(false);

	            int rowsDeleted = itmngDAO.deleteProducts(con, deleteItems);
	            System.out.println(rowsDeleted + "개의 상품이 삭제되었습니다.");

	            // 모든 삭제 작업이 성공하면 커밋
	            con.commit();
	    	} catch (SQLException e) {
	            // 예외 발생 시 롤백
	            try {
	                if (con != null) {
	                    con.rollback();
	                }
	            } catch (SQLException rollbackEx) {
	                rollbackEx.printStackTrace();
	            }
	            e.printStackTrace();
	        } finally {
	            try {
	                if (con != null) {
	                    // 트랜잭션 종료 및 AutoCommit 복원
	                    con.setAutoCommit(true);
	                    itMngDAO.closeDBConnection(con);
	                }
	            } catch (SQLException closeEx) {
	                closeEx.printStackTrace();
	            }
	        }
	    }

	    // 삭제 후 목록 페이지로 리다이렉트
	    response.sendRedirect("itMng.jsp");
	}

//        // 다시 목록을 불러와서 화면에 표시
//        controller(request, response);
    
	

	
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
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 드라이버 로딩
			// Class.forName : String 변수로 class 생성
			Class.forName(driver);
			System.out.println("★ Oracle 드라이버 로딩 성공 ★");
			
			// DB 접속
			con = DriverManager.getConnection(url, user, password);
			System.out.println("★ Connection 생성 성공 ★");
			
			
			// SQL 작성
			String query = "";
			// 무조건 앞에 한 칸 띄워서 작성 " select";
			query += " SELECT pname, sct, pnum, wzone, pday, psize";
			query += " FROM pd_list";
			query += " LEFT OUTER JOIN small_cat ON pd_list.scid = small_cat.scid";

			System.out.println("query : " + query);
			
			// SQL 실행 준비
			ps = con.prepareStatement(query);
			
			// SQL 실행, ResultSet으로 결과 확보
			rs = ps.executeQuery();

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
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
	
		
		// DB 담당에게 전달
				
		itMngDAO itmngDAO = new itMngDAO();
		itMngDTO itmngDTO = new itMngDTO();
		
		itmngDTO.setPnum(request.getParameter("pnum"));
		itmngDTO.setPname(request.getParameter("pname"));
		itmngDTO.setPsize(request.getParameter("psize"));
		itmngDTO.setWzone(request.getParameter("wzone"));
		itmngDTO.setSct(request.getParameter("sct"));
		itmngDTO.setPday(request.getParameter("pday"));
		
		try {
		    // 결과 받기
		    List<itMngDTO> list = itmngDAO.selectMng(itmngDTO);
		    request.setAttribute("list", list);

		    // forward 하기 전에 response에 데이터를 전송하지 않도록 수정
		    request.getRequestDispatcher("itemMng.jsp").forward(request, response);
//		    response.sendRedirect("itemMng.jsp");
		} catch (Exception e) {
		    e.printStackTrace();
		}
    }
		
}

		
	}