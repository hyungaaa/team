package com.spring.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.servlet.UserInfoDTO;

@Repository
public class UserInfoDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 로그인 (아이디 일치하는 열 조회하고, 비밀번호 일치여부 확인)
    public UserInfoDTO loginID(UserInfoDTO dto) {
        // SQL 실행
        UserInfoDTO user = sqlSession.selectOne("mapper.login.selectUserByuuid", dto);
        return user;
    }
    
    
}

