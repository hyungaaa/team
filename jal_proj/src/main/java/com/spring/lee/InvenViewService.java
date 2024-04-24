package com.spring.lee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvenViewService {
	
	@Autowired
	InvenViewDAO invenViewDAO;
	
	// select
	public List selectInven() {
		return invenViewDAO.selectInven();
	}
	
	// update
	public int updateInven(InvenDTO2 dto) {
		return invenViewDAO.updateInven(dto);
	}
}
