package jal_project_lim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ItemMng")
public class IMngServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
//		resp.sendRedirect("param.jsp?id=" + id);
		
		// forward 방식 -> 리스펀스를 넘겨줌으로서 param.jsp가 직접 응답
//		request.getRequestDispatcher("param.jsp?id= + id").forward(request, resp);
		// 어차피 request를 전달하고 jsp는 거기서 id값을 꺼낼 수 있음 
//		request.getRequestDispatcher("param.jsp").forward(request, resp);
		
//		request.setAttribute("id2", id);
		
		List<String> list = new ArrayList<String>();
		list.add("임");
		list.add("가");
		list.add("현");
		
		request.setAttribute("list", list);
		
		// id2 라는 새로운 값
//		request.setAttribute("id2", id);
		request.getRequestDispatcher("itemMng.jsp").forward(request, response);
	}


	

}
