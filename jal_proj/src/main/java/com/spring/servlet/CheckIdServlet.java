package com.spring.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/idcheck.do")
public class CheckIdServlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	UserInfoDTO userInfoDTO = new UserInfoDTO();
    	
        String uuid = request.getParameter("uuid");
        userInfoDTO.setUuid(uuid);
        
        
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        
        //ID 중복확인
        boolean isDuplicate = userInfoDAO.checkIdExists(userInfoDTO);
        
        if(isDuplicate || uuid.length() < 4){
            String htmlResponse = "invalid";

            response.getWriter().println(htmlResponse);
        	
        } else { 
	        String htmlResponse = "valid";
	
	        response.getWriter().println(htmlResponse);
        }
    }

}