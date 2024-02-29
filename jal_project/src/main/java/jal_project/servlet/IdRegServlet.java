package jal_project.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.human.emp.dao.EmpDAO;
import kr.or.human.emp.view.EmpView;

/**
 * Servlet implementation class IdRegServlet
 */
@WebServlet("/idreg.do")
public class IdRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// 전달받은 값parameter 확보
		String unum = request.getParameter("unum");
		String uuid = request.getParameter("uuid");
		String uemail = request.getParameter("uemail");
		int rct = 1;
				
		// db 담당에게 전달하고
		ReqListDAO reqListDAO = new ReqListDAO();
		
		// 결과를 받아서
		// 유효한 사원번호인지 확인값 전달..
		
		// view 담당에게 전달
		//jsp
//		EmpView empView = new EmpView();
//		StringBuffer sb = empView.drawList(list);
//
//		response.getWriter().println(sb);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
