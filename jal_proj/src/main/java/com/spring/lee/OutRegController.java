package com.spring.lee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OutRegController {
	
	@Autowired
	OutRegService outRegService;
	
	@RequestMapping("/outReg")
	public String listOutRegPd(
		Model model
	) {
		List pdList = outRegService.listPd();
		List pdOutList = outRegService.listPdin();
		
		System.out.println("controller > listOutRegPd pdList : " + pdList);
		System.out.println("controller > listOutRegPd pdOutList : " + pdOutList);
		
		System.out.println("out - pdList.size() : " + pdList.size());
		System.out.println("out - pdOutList.size() : " + pdOutList.size());
		
		model.addAttribute("pdList", pdList);
		model.addAttribute("pdOutList", pdOutList);
		
		return "outReg";
	}
	
	@RequestMapping(value="/outReg/search", method=RequestMethod.GET)
	public String listInRegPd2(
			@RequestParam("searchInput") String searchInput,
			Model model) {
		
		System.out.println("searchInput : " + searchInput);
		List pdList = outRegService.listPd(searchInput);
		List pdOutList = outRegService.listPdin();
		
		System.out.println("controller > listOutRegPd2 pdList : " + pdList);
		System.out.println("controller > listOutRegPd2 pdOutListList : " + pdOutList);
		
		System.out.println("out - pdList.size() : " + pdList.size());
		System.out.println("out - pdOutList.size() : " + pdOutList.size());
		
		model.addAttribute("pdList", pdList);
		model.addAttribute("pdOutList", pdOutList);
		
		return "outReg";
	}
}
