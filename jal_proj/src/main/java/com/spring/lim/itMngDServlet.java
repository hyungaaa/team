package com.spring.lim;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/itMngD")
public class itMngDServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");

        String[] selectedItems = request.getParameterValues("selectedItems");

        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
        String user = "scott_jal";
        String password = "jal123456";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName(driver);
            System.out.println("★ Oracle 드라이버 로딩 성공 ★");

            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false); // 트랜잭션 시작
            System.out.println("★ Connection 생성 성공 ★");

            String query = "DELETE FROM pd_list WHERE pnum = ?";
            ps = con.prepareStatement(query);
            System.out.println(selectedItems);

            if (selectedItems != null) {
            	// (selectedItems) 에서 선택 한 거에서 하나씩 나옴
                for (String pnum : selectedItems) {
                    ps.setString(1, pnum);
                    ps.executeUpdate();
                }
            }

            con.commit(); // 모든 삭제가 성공하면 커밋
//            System.out.println("선택된 제품 삭제 완료.");
         // 삭제 후 목록 페이지로 리다이렉트
//            request.getRequestDispatcher("itMngD");
//            request.getRequestDispatcher("itMngD");
            response.sendRedirect("itMng");


//        } catch (SQLException e) {
//            e.printStackTrace();
//            response.getWriter().println("데이터베이스 오류 발생");
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.getWriter().println("에러 발생~~~");
            // 예외 처리
        } catch (SQLException e) {
                e.printStackTrace();
                try {
                    if (con != null) {
                        con.rollback();
                    }
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
                response.getWriter().println("데이터베이스 오류 발생");
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("에러 발생~~~");
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
         
        } catch (Exception e) {
            e.printStackTrace();
            
        	}
        }
    }
    
}
        
    




	
