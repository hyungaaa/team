package com.spring.lee;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InRegDAO2 {

	@Autowired
	private SqlSession sqlSession;
	
	// 제품 select
	public List selectPdList() {
		List list = sqlSession.selectList("mapper.pd.selectPd");
		return list;
	}
	
	public List selectPdList(String searchInput) {
		List list = sqlSession.selectList("mapper.pd.selectPd", searchInput);
		return list;
	}
	
	// 입고 등록된 제품 select (pdDTO, pd_inDTO 조인)
	public List selectPdinList() {
		List list = sqlSession.selectList("mapper.pd.selectPdin");
		return list;
	}
	
	public int insertPdinList(JoinedDTO joinedDTO) {
		
		System.out.println("joinedDTO.getPdDTO().pnum : " + joinedDTO.getPdDTO().pnum);
		System.out.println("joinedDTO.getPd_inDTO().pnum : " + joinedDTO.getPd_inDTO().wzone);
		System.out.println("joinedDTO.getPd_inDTO().pnum : " + joinedDTO.getPd_inDTO().pincnt);
		System.out.println("joinedDTO.getPd_inDTO().pnum : " + joinedDTO.getPd_inDTO().pnote);
		int result = sqlSession.insert("mapper.pd.insertPdin", joinedDTO);
		return result;
	}
	
}
