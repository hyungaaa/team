package Mng;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userMng")
public class UserMngServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8;");

		// DAO를 통해 모든 테이블에서 데이터 조회
		UserMngDAO userMngDAO = new UserMngDAO();
		List<UserMngDTO> list = null;
		try {
			list = userMngDAO.selectAllTables();
		} catch (Exception e) {
			e.printStackTrace();
			// 예외 처리
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database Error");
			return;
		}

		// 결과를 request에 저장
		request.setAttribute("userList", list);
//		request.setAttribute("userList2", list);

		// view로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher("/userMng.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 클라이언트로부터 전송된 사용자 ID를 받아옴
		String userId = request.getParameter("userId");

		// UserMngDAO를 사용하여 사용자 삭제 작업 수행
		UserMngDAO dao = new UserMngDAO();
		boolean isDeleted = dao.deleteUser(userId);

		// 클라이언트에 응답 보내기
		response.setContentType("text/plain"); // 텍스트 형식으로 응답
		PrintWriter out = response.getWriter();
		if (isDeleted) {
			out.print("User deleted successfully");
		} else {
			out.print("Failed to delete user");
		}
		out.flush();
	}
}
