import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

@WebServlet("/sendpw")
public class SendPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	UserInfoDTO userInfoDTO = new UserInfoDTO();
    	
    	
    	
    	
    	
    	
    	
    	
//	        // DB 연결
//	        Connection con = null;
//	        try {
//	            con = DBUtil.getConnection(); // DBUtil 클래스는 DB 연결을 위한 유틸리티 클래스입니다.
//	            UserDAO dao = new UserDAO();
//	
//	            // 사용자 정보 가져오기
//	            List<UserDTO> userList = dao.getUserInfo(con);
//	
//	            // 각 사용자에게 임시 비밀번호 전송
//	            for (UserDTO user : userList) {
//	                String email = user.getEmail();
//	                String newPassword = generateRandomPassword(); // 임시 비밀번호 생성
//	                sendEmail(email, newPassword); // 이메일 전송
//	            }
//	
//	            response.getWriter().println("이메일 전송 완료!");
//	
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } finally {
//	            if (con != null) {
//	                try {
//	                    con.close();
//	                } catch (SQLException e) {
//	                    e.printStackTrace();
//	                }
//	            }
//	        }
    }


    private void sendEmail(String email, String newPassword) {
        // 이메일 전송 로직 구현
    	// 이메일 정보
        String to = "recipient@example.com";
        String from = "your.email@gmail.com";
        final String username = "your.email@gmail.com";
        final String password = "yourpassword";

        // SMTP 서버 설정
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // 세션 생성 및 인증
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // 이메일 메시지 작성
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("임시 비밀번호 안내");
            message.setText("안녕하세요,\n\n새로운 임시 비밀번호는 " + generateRandomPassword() + " 입니다.");

            // 이메일 발송
            Transport.send(message);

            System.out.println("이메일 전송 완료!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}