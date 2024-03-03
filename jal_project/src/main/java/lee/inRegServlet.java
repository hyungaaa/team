package lee;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inReg")
public class inRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글 깨짐 방지
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8;");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 전달받은 값 parameter 확보
//		String pnum = request.getParameter("pnum");
//		String pname = request.getParameter("pname");
//		String psize = request.getParameter("psize");
//		String punit = request.getParameter("punit");
		
		String searchInput = request.getParameter("searchInput");
		
		// DB 담당에게 전달
		InRegDAO inRegDAO = new InRegDAO();
		
		PdDTO pdDTO = new PdDTO();
//		pdDTO.setPnum(pdDTO.getPnum());
//		pdDTO.setPname(pdDTO.getPname());
//		pdDTO.setPsize(pdDTO.getPsize());
//		pdDTO.setPunit(pdDTO.getPunit());
		
		// 결과 받기
		List list = inRegDAO.selectPd(pdDTO, searchInput);
		System.out.println("이건 servlet: searchInput " + searchInput);
//		System.out.println(list);
//		System.out.println(((PdDTO)list.get(0)).getPnum());
		
		request.setAttribute("list", list);
		
		// view 담당에게 전달
		request.getRequestDispatcher("inReg.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
