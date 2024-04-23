package com.spring.lee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InRegService {

	@Autowired
	InRegDAO inRegDAO;
	
	public List listPd() {
		return inRegDAO.selectPdList();
	}
	
	/////////////////////////////////
	// 검색 select
	public List listPd(String searchInput) {
		return inRegDAO.selectPdList(searchInput);
	}
	
	// pd_in select
	public List listPdin() {
		return inRegDAO.selectPdinList();
	}
	/////////////////////////////////
	
	// pd_in insert
	public int insertInReg(JoinedDTO joinedDTO) {
		return inRegDAO.insertPdinList(joinedDTO);
	}
	
	// pd_in update
	public int updateInReg(String chkValue) {
		return inRegDAO.updatePdinList(chkValue);
	}
	
	public int deleteInReg(String chkValue ) {
		return inRegDAO.deletePdinList(chkValue);
	}
}
