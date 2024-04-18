package com.spring.y_02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardListService {
	
	@Autowired
	BoardListDAO2 boardListDAO;
	
	// select
	public List selectList() {
		return boardListDAO.selectList();
	}
}
