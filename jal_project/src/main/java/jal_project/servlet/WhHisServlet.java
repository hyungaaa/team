package jal_project.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


/**
 * Servlet implementation class WhHisServlet
 */
@WebServlet("/whhis.do")
public class WhHisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		
		WhHisDAO dao = new WhHisDAO();
        List<WhHisDTO> whHisList = dao.getWhHisList();

        // JSON 문자열 생성
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");
        for (int i = 0; i < whHisList.size(); i++) {
            WhHisDTO dto = whHisList.get(i);
            jsonBuilder.append("{");
            jsonBuilder.append("\"wid\":").append(dto.getWid()).append(",");
            jsonBuilder.append("\"wzone\":\"").append(dto.getWzone()).append("\",");
            jsonBuilder.append("\"wdate\":\"").append(dto.getWdate()).append("\",");
            jsonBuilder.append("\"wcnt\":").append(dto.getWcnt()).append(",");
            jsonBuilder.append("\"wpercent\":").append(dto.getWpercent());
            jsonBuilder.append("}");
            if (i < whHisList.size() - 1) {
                jsonBuilder.append(",");
            }
        }
        jsonBuilder.append("]");

        // 응답 보내기
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(jsonBuilder.toString());
        out.flush();
        
    }

}