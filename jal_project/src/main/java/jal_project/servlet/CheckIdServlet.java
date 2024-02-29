package jal_project.servlet;

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
        String uuid = request.getParameter("uuid");
        boolean isDuplicate = checkIdExists(uuid);

        if(isDuplicate || uuid.length() < 4){
        	System.out.println("uuid: "+ uuid);
            System.out.println("중복아이디 여부: " + isDuplicate);
            String htmlResponse = "invalid";

            response.getWriter().println(htmlResponse);
        	
        } else { 
	        System.out.println("uuid: "+ uuid);
	        System.out.println("중복아이디 여부: " + isDuplicate);
	        String htmlResponse = "valid";
	
	        response.getWriter().println(htmlResponse);
        }
    }

    private boolean checkIdExists(String uuid) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
        String user = "scott_jal";
        String password = "jal123456";

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user_info WHERE uuid = ?");
            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            boolean isDuplicate = rs.next();
            rs.close();
            ps.close();
            con.close();
            return isDuplicate;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}