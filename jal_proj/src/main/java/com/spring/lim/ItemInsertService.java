package com.spring.lim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.y_02.BoardListDTO;

@Service
public class ItemInsertService {
	
	@Autowired
	ItemInsertDAO itemInsertDAO;
	
	// insert
	public int insertItem(ItMngDTO dto) {
		return itemInsertDAO.insertItem(dto);
	}

	// delete
	public int deleteItem(ItMngDTO dto) {
		return itemInsertDAO.deleteItem(dto);
	}
	
	// select where
	public List itemDetail(ItMngDTO dto) {
		return itemInsertDAO.itemDetail(dto);
	}
}
