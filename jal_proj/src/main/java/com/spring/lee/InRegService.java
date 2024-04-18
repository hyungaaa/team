package com.spring.lee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InRegService {

	@Autowired
	InRegDAO2 inRegDAO;
	
	public List listPd() {
		return inRegDAO.selectPdList();
	}
	
	public List listPd(String searchInput) {
		return inRegDAO.selectPdList(searchInput);
	}
	
	public List listPdin() {
		return inRegDAO.selectPdinList();
	}
}
