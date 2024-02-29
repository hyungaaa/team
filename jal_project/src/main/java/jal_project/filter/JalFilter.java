package jal_project.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class JalFilter extends HttpFilter implements Filter {
       

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter 실행");
		
		if(request instanceof HttpServletRequest) {
			HttpServletRequest req = (HttpServletRequest) request;
			
			String url = req.getRequestURI();
			System.out.println("요청 url: " + url);
			
			
			// 반복해야할 작업 - 모든것이 거쳐감
			request.setCharacterEncoding("utf-8");
			//css 파일인 경우는 따로처리
			if (url.endsWith(".css")) {
			    response.setContentType("text/css; charset=utf-8");
			} else {
				response.setContentType("text/html; charset=utf-8;");
			}
			
			//indexOf 그 글씨 포함여부 : 로그인으로 접속하려고하면..
			if(url.indexOf("login.jsp") != -1 
					|| url.indexOf("login.do") != -1 
					|| url.indexOf("/logout") != -1 
					|| url.indexOf("/join.do") != -1){
				// 그냥 통과
				// 서블릿 등의 동작
				chain.doFilter(request, response);
			} else {
			
				HttpSession session = req.getSession();
				
				String isLogon = (String)session.getAttribute("isLogon");
				
				if("ok".equals(isLogon)) {
					//로그인 했다면
					
					chain.doFilter(request, response);
				} else {
					//로그인을 안했다면
					HttpServletResponse resp = (HttpServletResponse) response;
					resp.sendRedirect("login.jsp");

					
				}
			
			}
		}
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
