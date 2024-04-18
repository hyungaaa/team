//package com.spring.Mng;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/userMng")
//public class UserMngServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// DAO를 통해 모든 테이블에서 데이터 조회
//		UserMngDAO userMngDAO = new UserMngDAO();
//		UserMngDAO2 userMngDAO2 = new UserMngDAO2();
//		List<UserMngDTO> resultList = null;
//		List<UserMngDTO2> resultList2 = null;
//		try {
//			resultList = userMngDAO.selectAllTables();
//			resultList2 = userMngDAO2.selectAllTables2();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			// 데이터베이스 오류 처리
//			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database Error: " + e.getMessage());
//			return;
//		}
//
//		// 결과를 request에 저장
//		request.setAttribute("userList", resultList);
//		request.setAttribute("userList2", resultList2);
//
//		// view로 포워딩
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/userMng.jsp");
//		dispatcher.forward(request, response);
//	}
//}
