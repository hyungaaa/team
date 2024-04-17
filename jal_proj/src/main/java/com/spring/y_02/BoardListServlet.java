package com.spring.y_02;

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

		// select
		BoardListDAO dao = new BoardListDAO();
		List list = dao.selectBoard();

		// insert
		String btitle = request.getParameter("btitle");
		String btext = request.getParameter("btext");
		
		BoardListDTO boardListDTO = new BoardListDTO();
		boardListDTO.setBtitle(btitle);	
		boardListDTO.setBtext(btext);
		System.out.println(btitle);
		System.out.println(btext);
		int result = dao.insert(boardListDTO);
		System.out.println("insert 결과 : " + result);
		
		request.setAttribute("list", list);
		request.setAttribute("result", result);

		// view 담당에게 전달
		request.getRequestDispatcher("boardList.jsp").forward(request, response);
//      response.getWriter().println(sb);

	}


}