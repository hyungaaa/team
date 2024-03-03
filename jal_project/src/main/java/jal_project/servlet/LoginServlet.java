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
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		
		// 전달받은 parameter 확보
		String uid = request.getParameter("userid");
		String upass = request.getParameter("pw");		
		
		// DTO에 parameter 전달
		userInfoDTO.setUuid(uid);
		userInfoDTO.setUpass(upass);
		
				
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		
		// request, response 로그인 유지 용 세션 생성에 필요(?)
		userInfoDAO.loginID(userInfoDTO, request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	

}
