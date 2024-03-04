package Mng;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userMng2")
public class UserMngServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DAO를 통해 모든 테이블에서 데이터 조회
		UserMngDAO2 userMngDAO2 = new UserMngDAO2();
		List<UserMngDTO2> resultList = null;
		try {
			resultList = userMngDAO2.selectAllTables();
		} catch (Exception e) {
			e.printStackTrace();
			// 예외 처리
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database Error");
			return;
		}

		// 결과를 request에 저장
		request.setAttribute("userList2", resultList);

		// view로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher("/userMng.jsp");
		dispatcher.forward(request, response);
	}
}
