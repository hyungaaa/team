package com.spring.lee;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InRegDAO {

	@Autowired
	private SqlSession sqlSession;
	
	// 제품 select
	public List selectPdList() {
		List list = sqlSession.selectList("mapper.pdin.selectPd");
		return list;
	}
	
	//////////////////////////////////////
	public List selectPdList(String searchInput) {
		System.out.println(searchInput + " 검색");
		List list = sqlSession.selectList("mapper.pdin.selectPd", searchInput);
		return list;
	}
	
	// 입고 등록된 제품 select (pdDTO, pd_inDTO 조인)
	public List selectPdinList() {
		System.out.println("pdDTO, pd_inDTO 조인");
		List list = sqlSession.selectList("mapper.pdin.selectPdin");
		return list;
	}
	//////////////////////////////////////
	
	// pd_in insert
	public int insertPdinList(JoinedDTO joinedDTO) {
		System.out.println("in_insert");
		int result = sqlSession.insert("mapper.pdin.insertPdin", joinedDTO);
		return result;
	}
	
	// pd_in update
	public int updatePdinList(String chkValue) {
		System.out.println("in_update");
		int result = sqlSession.update("mapper.pdin.updatePdin", chkValue);
		return result;
	}
	
	// pd_in delete
	public int deletePdinList(String chkValue) {
		System.out.println("in_delete");
		int result = sqlSession.update("mapper.pdin.deletePdin", chkValue);
		return result;
	}	
		
}
