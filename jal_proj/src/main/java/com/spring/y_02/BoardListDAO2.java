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
	public List selectList() {
		List list = sqlSession.selectList("mapper.board.selectBdList");
		return list;
	}
	
	// select where
	public List selectedView(BoardListDTO dto) {
		List list = sqlSession.selectList("mapper.board.selectBd", dto);
		System.out.println("view : " +list);
		return list;
	}
	
	// insert
	public int insertBd(BoardListDTO dto) {
		int result = -9999;
		result = sqlSession.insert("mapper.board.insertBd", dto);
		System.out.println("insert 결과 : " + result);
		return result;
	}
}
