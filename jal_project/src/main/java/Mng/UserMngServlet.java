//package Mng;
//
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/userMng")
//public class UserMngServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// 한글 깨짐 방지
//		try {
//			request.setCharacterEncoding("UTF-8");
//			response.setContentType("text/html; charset=utf-8;");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
////		uname, unum, cname, ulevel, updv, updior, updr, updiom, updm, uum
////		rcategory, unum, uuid, uemail
//		String rcategory = request.getParameter("rcategory");
//		String uuid = request.getParameter("uuid");
//		String uemail = request.getParameter("uemail");
//		String unum = request.getParameter("unum");
//		String uname = request.getParameter("uname");
//		String cname = request.getParameter("cname");
//		String ulevel = request.getParameter("ulevel");
//		String updv = request.getParameter("updv");
//		String updior = request.getParameter("updior");
//		String updr = request.getParameter("updr");
//		String updiom = request.getParameter("updiom");
//		String updm = request.getParameter("updm");
//		String uum = request.getParameter("uum");
//		String rid = request.getParameter("rid");
//
//		// db 담당에게 전달하고
//		UserMngDAO usermngDAO = new UserMngDAO();
//
//		// 결과를 받아서
//		// DTO에 담아서 보내기
//		UserMngDTO usermngDTO = new UserMngDTO();
//		usermngDTO.setRcategory(rcategory);
//		usermngDTO.setUuid(uuid);
//		usermngDTO.setUemail(uemail);
//		usermngDTO.setUnum(unum);
//		usermngDTO.setUname(uname);
//		usermngDTO.setCname(cname);
//		usermngDTO.setUlevel(ulevel);
//		usermngDTO.setUpdv(updv);
//		usermngDTO.setUpdior(updior);
//		usermngDTO.setUpdr(updr);
//		usermngDTO.setUpdiom(updiom);
//		usermngDTO.setUpdm(updm);
//		usermngDTO.setUum(uum);
//		usermngDTO.setRid(rid);
//
//		List list = usermngDAO.selectuserMng(usermngDTO);
//		System.out.println(list);
//		System.out.println(((UserMngDTO) list.get(0)).getUuid());
//
//		request.setAttribute("list", list);
//		// view 담당에게 전달
//		request.getRequestDispatcher("/jsp/userMng.jsp").forward(request, response);
//
//	}
//
//}

package Mng;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userMng")
public class UserMngServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글 깨짐 방지
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8;");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// DAO를 통해 모든 테이블에서 데이터 조회
		UserMngDAO usermngDAO = new UserMngDAO();
		List<UserMngDTO> list = usermngDAO.selectAllTables();

		// 결과를 request에 저장
		request.setAttribute("userList", list);

		// view로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/userMng.jsp");
		dispatcher.forward(request, response);
	}
}
