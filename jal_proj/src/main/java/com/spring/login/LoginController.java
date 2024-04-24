package com.spring.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.servlet.UserInfoDTO;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginId(
			@RequestParam("userid") String uuid,
			@RequestParam("pw") String upass,
			HttpServletRequest request, HttpServletResponse response) {
		UserInfoDTO dto = new UserInfoDTO();
		dto.setUuid(uuid);
		dto.setUpass(upass);
		
		UserInfoDTO result = loginService.loginID(dto);
		System.out.println("result : " +result);
		System.out.println(dto);
		if (result != null) {
			// 비밀번호 일치 여부 확인
			if (dto.getUpass().equals(upass)) {
				System.out.println("login-pass");

				// 세션 생성 및 설정
				HttpSession session = request.getSession();
				session.setAttribute("isLogon", "ok");
				session.setAttribute("uname", dto.getUname());
				session.setAttribute("umaster", dto.getUmaster());
				session.setAttribute("uuid", dto.getUuid());  // 세션에 uuid 저장
				System.out.println("세션 생성 성공");
				// 로그인 성공 시 대시보드로 리디렉트
				return "redirect:/dashboard";

			} else {
				System.out.println("fail");

				// 로그인 실패 시 로그인페이지로 리디렉트
				return "login";
			}
		}
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String test2() {
		return "login";
	}
	
	@RequestMapping(value="/login2")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("logout 성공");
		return "redirect:/login";
	}

}
