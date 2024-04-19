package com.spring.lee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InRegController {
	
	@Autowired
	InRegService inRegService;
	
	@RequestMapping("/inReg")
	public String listInRegPd(
//		@RequestParam("searchInput") String searchInput,
		Model model
	) {
		List pdList = inRegService.listPd();
		List pdInList = inRegService.listPdin();
		
//		System.out.println("searchInput" + searchInput);
		
		System.out.println("controller > listInRegPd pdList : " + pdList);
		System.out.println("controller > listInRegPd pdInList : " + pdInList);
		
		System.out.println("pdList.size() : " + pdList.size());
		System.out.println("pdInList.size() : " + pdInList.size());
		
		model.addAttribute("pdList", pdList);
		model.addAttribute("pdInList", pdInList);
		
		return "inReg";
	}
	
	
	
	@RequestMapping("/inReg?searchInput=")
	public String listInRegPd2(
			@RequestParam("searchInput") String searchInput,
			Model model) {
		List pdList = inRegService.listPd(searchInput);
		List pdInList = inRegService.listPdin();
		
		System.out.println("searchInput : " + searchInput);
		
		System.out.println("controller > listInRegPd2 pdList : " + pdList);
		System.out.println("controller > listInRegPd2 pdInList : " + pdInList);
		
		System.out.println("pdList.size() : " + pdList.size());
		System.out.println("pdInList.size() : " + pdInList.size());
		
		model.addAttribute("pdList", pdList);
		model.addAttribute("pdInList", pdInList);
		
		return "inReg";
	}
	
}
