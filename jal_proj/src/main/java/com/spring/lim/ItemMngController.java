package com.spring.lim;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemMngController {
	
	@RequestMapping(value = "/itMng", method = RequestMethod.GET)
	public String test() {
		return "item";
	}
}
