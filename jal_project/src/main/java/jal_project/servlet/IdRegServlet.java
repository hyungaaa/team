package jal_project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/idreg.do")
public class IdRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserInfoDTO userInfoDTO = new UserInfoDTO();

		// 전달받은 parameter 확보
		String unum = request.getParameter("unum");
		String uuid = request.getParameter("uuid");
		String uemail = request.getParameter("uemail");

		int rct = 1;	// (사용자등록 요청 : 1, 비밀번호초기화 요청 : 2)
		userInfoDTO.setUnum(unum);
		userInfoDTO.setUuid(uuid);
		userInfoDTO.setUemail(uemail);
		
		// db 담당에게 전달하고
		ReqListDAO reqListDAO = new ReqListDAO();
		
		// 존재하는 사원번호인지 확인
		if(reqListDAO.checkUnum(userInfoDTO)) {
			// table에 insert 실행
			reqListDAO.insertReqList(userInfoDTO, rct);
			response.sendRedirect("login");

		}else{
			System.out.println("일치하는 사원번호 없음");
			
			String htmlResponse = "no match-unum";
            response.getWriter().println(htmlResponse);
            
			response.sendRedirect("login");
		};
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
