package com.spring.lee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InRegController {
	
	@Autowired
	InRegService inRegService;
	
	@RequestMapping("/inReg")
	public String listInRegPd(Model model) {
		List pdList = inRegService.listPd();
		List pdInList = inRegService.listPdin();
		
		System.out.println("controller > listInRegPd pdList : " + pdList);
		System.out.println("controller > listInRegPd pdInList : " + pdInList);
		
		System.out.println("pdList.size() : " + pdList.size());
		System.out.println("pdInList.size() : " + pdInList.size());
		
		model.addAttribute("pdList", pdList);
		model.addAttribute("pdInList", pdInList);
		
		return "inReg";
	}
	
//	@RequestMapping("/inReg2")
//	public String listInRegPdin(Model model) {
//		
//		
//		return "inReg";
//	}
}
