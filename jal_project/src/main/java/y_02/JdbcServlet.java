package y_02;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jdbc")
public class JdbcServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      controller(request, response);

   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      controller(request, response);
   }

   protected void controller(HttpServletRequest request, HttpServletResponse response) {
      // 한글 깨짐 방지
      try {
         request.setCharacterEncoding("UTF-8");
         response.setContentType("text/html; charset=utf-8;");
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      }

      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
      String user = "scott_jal";
      String password = "jal123456";

      try {

         // 드라이버 로딩
         // Class.forName : String 변수로 class 생성
         Class.forName(driver);
         System.out.println("Oracle 드라이버 로딩 성공");

         // DB 접속
         Connection con = DriverManager.getConnection(url, user, password);
         System.out.println("Connection 생성 성공");

//         String name = request.getParameter("name");
         // SQL 작성

         String query = "";
         query += " select";
         query += " *";
         query += " from";
         query += " bd_list";
         System.out.println("query : " + query);

         // SQL 실행 준비
         PreparedStatement ps = con.prepareStatement(query);
//         ps.setString(1, name);

         // SQL 실행, ResultSet으로 결과 확보
         ResultSet rs = ps.executeQuery();

         // DB 값을 활용
         // ResultSet에는 모든 줄이 담겨져 있음
         // rs.next() : 다음줄이 있는지 여부
         // next() 실행 후에 ResultSet에는 다음줄이 담김
//               if( rs.next() ) {
         while (rs.next()) {
            // getxxx, 전달인자로 컬럼명, 대소문자 구분 없음
            int bno = rs.getInt("bno");
            String uuid = rs.getString("uuid");
            String btitle = rs.getString("btitle");
            // 날짜 사용하고 싶으면 import된 클래스명이 같기 때문에
            // java.util.Date 이 형태로 써야 한다

            System.out.println("bno : " + bno);
            System.out.println("uuid : " + uuid);
            System.out.println("btitle : " + btitle);
            System.out.println("---------------------------");

            PrintWriter out = response.getWriter();
            out.println("<div>bno : " + bno + "</div>");
            out.println("<div>uuid : " + uuid + "</div>");
            out.println("<div>btitle : " + btitle + "</div>");
            out.println("<hr>");
         }

         rs.close();
         ps.close();
         con.close();

      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}