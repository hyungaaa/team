package com.spring.lim;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItMngDAO2 {

	@Autowired
	private SqlSession sqlSession;
	
	// select
	public List selectList() {
		List list = sqlSession.selectList("mapper.item.selectItem");
		return list;
	}
	public List selectList2() {
		List list = sqlSession.selectList("mapper.item.selectItem2");
		return list;
	}
	public List selectList3() {
		List list = sqlSession.selectList("mapper.item.selectItem3");
		return list;
	}
	public List selectList4() {
		List list = sqlSession.selectList("mapper.item.selectItem4");
		return list;
	}
	public List selectList5() {
		List list = sqlSession.selectList("mapper.item.selectItem5");
		return list;
	}
	
	
}
