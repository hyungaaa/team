package com.spring.lim;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemInsertDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertItem(ItMngDTO dto) {
		int result = -9999;
		result = sqlSession.insert("mapper.item.insertItem",dto);
		System.out.println("insert 결과 : " + result);
		return result;
	}
}
