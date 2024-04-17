package com.spring.y_02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardListController {
	
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public String test() {
		return "board";
	}

	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String test1() {
		return "boardWrite";
	}
}
