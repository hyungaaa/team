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
	
	// pd_out select
	public List listPdout() {
		return outRegDAO.selectPdOutList();
	}
	
	// pd_out select
	public List listPdout(String searchInput) {
		return outRegDAO.selectPdOutList(searchInput);
	}
	
	public int deleteOutReg(String chkValue ) {
		return outRegDAO.deletePdoutList(chkValue);
	}
	
}
