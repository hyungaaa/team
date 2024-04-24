package com.spring.lee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InvenViewController {
	
	@Autowired
	InvenViewService invenViewService;
	
	@RequestMapping("/invenView")
	public String selectInven(Model model) {
		List list = invenViewService.selectInven();
		if(list != null) {
			System.out.println("inven.size : " + list.size());
		}
		model.addAttribute("list", list);
		System.out.println("list : " + list);
		return "invent";
	}
}
