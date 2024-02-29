package Mng;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userMng")
public class userMngServlet extends HttpServlet {
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
//		uname, unum, cname, ulevel, updv, updior, updr, updiom, updm, uum
//		rcategory, unum, uuid, uemail
		String uname = request.getParameter("uname");
		String unum = request.getParameter("unum");
		String cname = request.getParameter("cname");
		String ulevel = request.getParameter("ulevel");
		String updv = request.getParameter("updv");
		String updior = request.getParameter("updior");
		String updr = request.getParameter("updr");
		String updiom = request.getParameter("updiom");
		String updm = request.getParameter("updm");
		String uum = request.getParameter("uum");
		String rcategory = request.getParameter("rcategory");
		String uuid = request.getParameter("uuid");
		String uemail = request.getParameter("uemail");

		// db 담당에게 전달하고
		userMngDAO usermngDAO = new userMngDAO();

		// 결과를 받아서
		// DTO에 담아서 보내기
		userMngDTO usermngDTO = new userMngDTO();
		usermngDTO.setUname(uname);
		usermngDTO.setUnum(unum);
		usermngDTO.setCname(cname);
		usermngDTO.setUlevel(ulevel);
		usermngDTO.setUpdv(updv);
		usermngDTO.setUpdior(updior);
		usermngDTO.setUpdr(updr);
		usermngDTO.setUpdiom(updiom);
		usermngDTO.setUpdm(updm);
		usermngDTO.setUum(uum);
		usermngDTO.setRcategory(rcategory);
		usermngDTO.setUuid(uuid);
		usermngDTO.setUemail(uemail);

		List list = usermngDAO.selectEmp(usermngDTO);
		System.out.println(list);
		System.out.println(((userMngDTO) list.get(0)).getUuid());

		request.setAttribute("list", list);
		// view 담당에게 전달
		request.getRequestDispatcher("/jsp/userMng.jsp").forward(request, response);
	}

}
