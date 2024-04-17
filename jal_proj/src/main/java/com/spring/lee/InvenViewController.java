package com.spring.lee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InvenViewController {

	@RequestMapping("/invenView")
	public String outReg() {
		return "invent";
	}
}
