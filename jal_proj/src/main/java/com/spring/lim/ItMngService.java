package com.spring.lim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItMngService {

	@Autowired
	ItMngDAO2 itMngDAO;

	// select
	public List selectList() {
		return itMngDAO.selectList();
	}
	public List selectList2() {
		return itMngDAO.selectList2();
	}
	public List selectList3() {
		return itMngDAO.selectList3();
	}
	public List selectList4() {
		return itMngDAO.selectList4();
	}
	public List selectList5() {
		return itMngDAO.selectList5();
	}

	
}
