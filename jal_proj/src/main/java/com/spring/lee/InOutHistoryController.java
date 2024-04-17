package com.spring.lee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InOutHistoryController {

	@RequestMapping("/inoutHistory")
	public String outReg() {
		return "inout";
	}
}
