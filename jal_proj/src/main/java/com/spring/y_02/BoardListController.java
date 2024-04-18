package com.spring.y_02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardListController {
	
	@Autowired
	BoardListService boardListService;
	
	// select
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public String selectList(Model model) {
		List list = boardListService.selectList();
		if(list != null) {
			System.out.println("list.size : " + list.size());
		}
		model.addAttribute("list", list);
		return "board";
	}
	
	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String test1() {
		return "boardWrite";
	}
}
