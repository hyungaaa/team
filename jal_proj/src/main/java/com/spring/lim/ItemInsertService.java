package com.spring.lim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemInsertService {
	
	@Autowired
	ItemInsertDAO itemInsertDAO;
	
	// insert
	public int insertItem(ItMngDTO dto) {
		return itemInsertDAO.insertItem(dto);
	}
}
