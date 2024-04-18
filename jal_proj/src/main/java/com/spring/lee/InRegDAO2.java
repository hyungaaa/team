package com.spring.lee;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InRegDAO2 {

	@Autowired
	private SqlSession sqlSession;
	
	public List selectPdList() {
		List list = sqlSession.selectList("mapper.pd.selectPd");
		return list;
	}
	public List selectPdinList() {
		List list = sqlSession.selectList("mapper.pd.selectPdin");
		return list;
	}
	
}
