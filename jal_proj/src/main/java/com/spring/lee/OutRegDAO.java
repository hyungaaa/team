package com.spring.lee;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OutRegDAO {

	@Autowired
	private SqlSession sqlSession;
	
	// 제품 select
	public List selectPdList() {
		List list = sqlSession.selectList("mapper.pdout.selectPd");
		return list;
	}
	
	public List selectPdList(String searchInput) {
		List list = sqlSession.selectList("mapper.pdout.selectPd", searchInput);
		return list;
	}
	
	// 입고 등록된 제품 select (pdDTO, pd_inDTO 조인)
	public List selectPdoutList() {
		List list = sqlSession.selectList("mapper.pdout.selectPdout");
		return list;
	}
	
	public int updatePdoutList(String chkValue) {
		int result = sqlSession.update("mapper.pdout.updatePdout", chkValue);
		return result;
	}
	
	// 입고 등록된 제품 select (pdDTO, pd_inDTO 조인) - out 검색
	public List selectPdOutList(String searchInput) {
		List list = sqlSession.selectList("mapper.pdout.selectPd", searchInput);
		return list;
	}
	
	// pd_out insert
	public int insertPdoutList(JoinedDTO joinedDTO) {
		int result = sqlSession.insert("mapper.pdout.insertPdout", joinedDTO);
		return result;
	}
	
	// pd_in delete
	public int deletePdoutList(String chkValue) {
		int result = sqlSession.update("mapper.pdout.deletePdout", chkValue);
		return result;
	}
	
	
}
