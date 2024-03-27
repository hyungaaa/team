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
		
		String searchInput = request.getParameter("searchInput");
		String radioBtn = request.getParameter("radioBtn");
		System.out.println("radioBtn: " + radioBtn);
		
		
		// DB 담당에게 전달
		InRegDAO inRegDAO = new InRegDAO();
		
		PdDTO pdDTO = new PdDTO();
		Pd_inDTO pd_inDTO = new Pd_inDTO();
//		pdDTO.setPnum(pdDTO.getPnum());
//		pdDTO.setPname(pdDTO.getPname());
//		pdDTO.setPsize(pdDTO.getPsize());
//		pdDTO.setPunit(pdDTO.getPunit());
		
		// 결과 받기
		List list = inRegDAO.selectPd(pdDTO, searchInput);
		List list2 = inRegDAO.selectTbl(pdDTO, pd_inDTO);
		
		System.out.println("이건 servlet: searchInput " + searchInput);
//		System.out.println(((PdDTO)list.get(0)).getPnum());
		
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		
		// view 담당에게 전달
		request.getRequestDispatcher("inReg.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InRegDAO dao = new InRegDAO();
		Pd_inDTO dto = new Pd_inDTO();
		
		int cnt = dao.insertPd(dto);
		if(cnt == 1) {
			System.out.println("DB 입력 성공");
		} else {
			System.out.println("DB 입력 실패");
		}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
