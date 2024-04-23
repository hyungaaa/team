package com.spring.Mng;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MypageDAO {

	@Autowired
	private SqlSession sqlSession;

	public MypageDTO selectmyPageUserInfo(String uuid) {
		return sqlSession.selectOne("mapper.mypage.myPageUserInfo", uuid);
	}
	
	public int updateUserInfo(MypageDTO myPageUserInfo) {
        return sqlSession.update("mapper.mypage.updateUserInfo", myPageUserInfo);
    }
}
