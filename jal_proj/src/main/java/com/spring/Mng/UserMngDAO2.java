package com.spring.Mng;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserMngDAO2 {

    @Autowired
    private SqlSession sqlSession;

    public List<UserMngDTO2> selectUserInfo() {
        return sqlSession.selectList("mapper.userMng.userInfo");
    }

    public List<UserMngDTO2> selectReqList() {
        return sqlSession.selectList("mapper.userMng.reqList");
    }
}
