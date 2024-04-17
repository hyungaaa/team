package com.spring.lim;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/itMngNew")
public class itMngInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8;");
		
		ItMngNewDAO itnDAO = new ItMngNewDAO();
		
		String command = request.getParameter("command");
		if("insert".equals(command)) {
			String img = request.getParameter("img");
			String pname = request.getParameter("pname");
			String sct = request.getParameter("sct");
			String pnum = request.getParameter("pnum");
			String wzone = request.getParameter("wzone");
			String bct = request.getParameter("bct");
			String psize = request.getParameter("psize");
			String punit = request.getParameter("punit");
			String pday = request.getParameter("pday");
			String pamountStr = request.getParameter("pamount");
			int pamount = Integer.parseInt(pamountStr);
			
			ItMngNewDTO itnDTO = new ItMngNewDTO();
			
			itnDTO.setImg(img);
			itnDTO.setPname(pname);
			itnDTO.setSct(sct);
			itnDTO.setPnum(pnum);
			itnDTO.setWzone(wzone);
			itnDTO.setBct(bct);
			itnDTO.setPsize(psize);
			itnDTO.setPunit(punit);
			itnDTO.setPday(pday);
			itnDTO.setPamount(pamount);
			
			int result = itnDAO.insertIt(itnDTO);
			System.out.println("insert 결과 : " + result );
			
			// list 페이지로 이동
			response.sendRedirect("itMng");

			
			
		}

	}
}
