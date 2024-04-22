package com.spring.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.servlet.UserInfoDTO;

@Service
public class LoginService {
	
	@Autowired
	UserInfoDAO userInfoDAO;
	
	public UserInfoDTO loginID(UserInfoDTO dto) {
		return userInfoDAO.loginID(dto);
	}
}
