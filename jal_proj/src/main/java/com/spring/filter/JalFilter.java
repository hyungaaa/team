//package com.spring.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebFilter("/*")
//public class JalFilter extends HttpFilter implements Filter {
//       
//	
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		System.out.println("doFilter 실행");
//		
//		if(request instanceof HttpServletRequest) {
//			HttpServletRequest req = (HttpServletRequest) request;
//	        
//	        String url = req.getRequestURI();
//	        System.out.println("요청 url123: " + url);
//	        
////	        // 정적 자원인 경우 필터를 실행하지 않음
////	        if (url.endsWith(".css") || url.endsWith(".js") || url.endsWith(".png")) {
////	            chain.doFilter(request, response);
////	            return;
////	        }
//			
//			
//			// 반복해야할 작업 - 모든것이 거쳐감
//			request.setCharacterEncoding("utf-8");
//			
//			
//			//indexOf 그 글씨 포함여부 : 로그인으로 접속하려고하면..
//			if(url.indexOf("login") != -1 
//				|| url.indexOf(".do") != -1 
//				|| url.indexOf(".jsp") != -1 
//				|| url.indexOf("/logout") != -1 
//				|| url.indexOf("/login") != -1
////				|| url.indexOf("/css/") != -1
//				|| url.indexOf(".css") != -1
//				|| url.indexOf("/js/") != -1
//				|| url.indexOf("/img/") != -1){
//				// 그냥 통과
//				// 원하는 페이지(예외처리한것들)로 이동 
//				System.out.println("주소 예외처리로 통과됨");
//				chain.doFilter(request, response);	//(서블릿 등의 동작)
//			} else {
//				// 예외로 설정되지 않은 페이지 입력되었을때
//				System.out.println("주소 예외처리 이외의 링크임-> 로그온 여부 체크 예정");
//
//				
//				//세션에 로그온 되어있는지 정보 가져오기
//				HttpSession session = req.getSession();
//				String isLogon = (String)session.getAttribute("isLogon");
//				
//				if("ok".equals(isLogon)) {
//					//로그온 되어있다면
//					//원하는 페이지로 이동
//					chain.doFilter(request, response);
//				} else {
//					//로그인을 안했다면
//					HttpServletResponse resp = (HttpServletResponse) response;
//					//로그인 페이지로 이동
//					resp.sendRedirect("login");
//
//				}
//			
//			}
//		}
//		
//	}
//
//
//	public void init(FilterConfig fConfig) throws ServletException {
//	}
//	public void destroy() {
//		
//	}
//
//}
package com.spring.filter;

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

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter 실행");

		if (request instanceof HttpServletRequest) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession session = req.getSession(false); // 세션을 가져오되, 없으면 생성하지 않음

			String url = req.getRequestURI();
			System.out.println("요청 URL: " + url);

			// UTF-8 인코딩 설정
			request.setCharacterEncoding("utf-8");

			// 필터 예외 설정: 로그인, 로그아웃, 정적 리소스
			if (url.contains("login") || url.contains("logout") || url.contains(".css") || url.contains(".js")
					|| url.contains(".png") || url.contains(".jpg")) {
				chain.doFilter(request, response);
				return;
			}

			// 관리자 페이지 접근 제한
			if (url.contains("userMng")) {
				String uuid = (session != null) ? (String) session.getAttribute("uuid") : null; // 세션에서 uuid 가져오기
				if ("admin".equals(uuid)) {
					chain.doFilter(request, response); // 관리자면 통과
				} else {
					resp.sendRedirect("dashboard"); // 관리자가 아니면 접근 제한 페이지로 리디렉트
					return;
				}
			} else {
				// 일반 페이지 접근 권한 검사
				if (session != null && "ok".equals(session.getAttribute("isLogon"))) {
					chain.doFilter(request, response); // 로그인 상태면 통과
				} else {
					resp.sendRedirect("login"); // 로그인 상태가 아니면 로그인 페이지로 리디렉트
				}
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// 필터 초기화 작업
	}

	public void destroy() {
		// 필터 제거 작업
	}
}
