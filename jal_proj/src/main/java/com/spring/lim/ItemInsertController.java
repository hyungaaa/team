package com.spring.lim;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemInsertController {
	
	@RequestMapping("/itemNew")
	public String test() {
		return "itemNew";
	}
}
