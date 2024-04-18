package com.spring.y_02;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardListDAO2 {

	@Autowired
	private SqlSession sqlSession;

	// select
	public List selectEmp() {
		List list = sqlSession.selectList("mapper.emp.selectEmp");

		return list;
	}
}
