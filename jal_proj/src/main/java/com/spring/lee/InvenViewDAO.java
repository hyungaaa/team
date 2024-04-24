package com.spring.lee;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InvenViewDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// select
	public List selectInven() {
		List list = sqlSession.selectList("mapper.inven.selectInven");
		return list;
	}
}
