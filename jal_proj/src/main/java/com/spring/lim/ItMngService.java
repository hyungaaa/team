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

	// select detail
	public List selectDetail(ItMngDTO dto) {
		return itMngDAO.selectDetail(dto);
	}
}
