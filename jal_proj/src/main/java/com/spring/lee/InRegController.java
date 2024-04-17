package com.spring.lee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InRegController {

	@RequestMapping("/inReg")
	public String inReg() {
		return "inReg";
	}
}
