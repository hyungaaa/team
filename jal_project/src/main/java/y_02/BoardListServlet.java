package y_02;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		// 전달받은 값 parameter 확보
//		String uuid = request.getParameter("uuid");
//		String strbno = request.getParameter("bno");
//		String btitle = request.getParameter("btitle");
//		String pnum = request.getParameter("pnum");
//		String bdate = request.getParameter("bdate");
//		String strbbits = request.getParameter("bbits");
//		
//		
//		int bno = -1;
//		int bbits = -1;
//		try {
//			bno = Integer.parseInt(strbno);
//			bbits = Integer.parseInt(strbbits);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		// db 담당에게 전달하고
		BoardListDAO dao = new BoardListDAO();
		
//		dto.setBno(bno);
//		dto.setUuid(uuid);
//		dto.setBtitle(btitle);
//		dto.setPnum(pnum);
//		dto.setBdate(bdate);
//		dto.setBbits(bbits);

		// 결과를 받아서
//      List list = dao.selectBoard(bno, uuid);

		List list = dao.selectBoard();
		System.out.println(list);
//		System.out.println(((BoardListDTO)list.get(0)).getBno());


		request.setAttribute("list", list);

		// view 담당에게 전달
		request.getRequestDispatcher("boardList.jsp").forward(request, response);
//      response.getWriter().println(sb);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		// 한글 깨짐 방지
//		try {
//			request.setCharacterEncoding("UTF-8");
//			response.setContentType("text/html; charset=utf-8;");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//
//		String uuid = request.getParameter("uuid");
//		String strbno = request.getParameter("bno");
//		int bno = -1;
//		try {
//			bno = Integer.parseInt(strbno);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		BoardListDTO dto = new BoardListDTO();
//		dto.setBno(bno);
//		dto.setUuid(uuid);
		
//		BoardListDAO dao = new BoardListDAO();
//		int result = dao.updateBdl(dto);
//		System.out.println("업데이트 결과 : " + result);
		

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}