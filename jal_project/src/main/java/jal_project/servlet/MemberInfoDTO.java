package jal_project.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/memberInfoDTO")
public class MemberInfoDTO extends HttpServlet {

	private String unum;
	private String uuid;

	public String getUnum() {
		return unum;
	}
	
	public void setUnum(String unum) {
		this.unum = unum;
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
