package com.spring.lee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OutRegController {

	@RequestMapping("/outReg")
	public String outReg() {
		return "outReg";
	}
}
