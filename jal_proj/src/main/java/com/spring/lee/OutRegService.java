package com.spring.lee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutRegService {

	@Autowired
	OutRegDAO outRegDAO;
	
	public List listPd() {
		return outRegDAO.selectPdList();
	}
	
	// 검색 select
	public List listPd(String searchInput) {
		return outRegDAO.selectPdList(searchInput);
	}
	
	// pd_in select
	public List listPdout() {
		return outRegDAO.selectPdoutList();
	}
	
	// pd_out select 팝업
	public List listPdout(String searchInput) {
		return outRegDAO.selectPdOutList(searchInput);
	}
	
	// pd_out insert
	public int insertOutReg(JoinedDTO joinedDTO) {
		return outRegDAO.insertPdoutList(joinedDTO);
	}
	
	//pd_out update
	public int updateOutReg(String chkValue) {
		return outRegDAO.updatePdoutList(chkValue);
	}
	
	public int deleteOutReg(String chkValue ) {
		return outRegDAO.deletePdoutList(chkValue);
	}
	
	
}
