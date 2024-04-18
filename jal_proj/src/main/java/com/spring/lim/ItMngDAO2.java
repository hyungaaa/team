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
	
	// select detail
	public List selectDetail(ItMngDTO dto) {
		List list = sqlSession.selectList("mapper.item.selectDetail", dto);
		return list;
	}
}
