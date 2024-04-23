package com.spring.lim;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemInsertDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// insert
	public int insertItem(ItMngDTO dto) {
		int result = -9999;
		result = sqlSession.insert("mapper.item.insertItem",dto);
		System.out.println("insert 결과 : " + result);
		return result;
	}
	
	// delete
	public int deleteItem(ItMngDTO dto) {
		int result = -9999;
		result = sqlSession.delete("mapper.item.deleteItem",dto);
		System.out.println("delete 결과 : " + result);
		return result;
	}
	
	// select where
	public List itemDetail(ItMngDTO dto) {
		List list = sqlSession.selectList("mapper.item.itemDetail", dto);
		System.out.println("view : " +list);
		return list;
	}
	
	
}
