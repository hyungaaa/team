package y_02;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String bnostring = request.getParameter("bno");
		int bno = Integer.parseInt(bnostring);
		
		BoardListDTO boardListDTO = new BoardListDTO();
		BoardListDAO boardListDAO = new BoardListDAO();
		
		boardListDTO.setBno(bno);
		
		List list = boardListDAO.selectedView(boardListDTO);
            
		  
		request.setAttribute("bno", list.get(0));
		request.setAttribute("btitle", list.get(1));
		request.setAttribute("bdate", list.get(2));
		request.setAttribute("uname", list.get(3));
		request.setAttribute("pnum", list.get(4));
		request.setAttribute("btext", list.get(5));

		// view 담당에게 전달
		request.getRequestDispatcher("board.jsp").forward(request, response);
		System.out.println(boardListDTO.getBtitle());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
