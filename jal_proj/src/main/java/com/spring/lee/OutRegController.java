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
		List pdOutList = outRegService.listPdout();
		
		model.addAttribute("pdList", pdList);
		model.addAttribute("pdOutList", pdOutList);
		
		return "outReg";
	}
	
	@RequestMapping(value="/outReg/search", method=RequestMethod.GET)
	public String listInRegPd2(
			@RequestParam("searchInput") String searchInput,
			Model model) {
		
		System.out.println("out - searchInput : " + searchInput);
		
		List pdList = outRegService.listPd();
		// 조인한거임
//		List pdOutList = outRegService.listPdout();

		List pdOutList = outRegService.listPdout(searchInput);
		
		System.out.println("controller > listOutRegPd2 pdList : " + pdList);
		System.out.println("controller > listOutRegPd2 pdOutListList : " + pdOutList);
		
		model.addAttribute("pdList", pdList);
		model.addAttribute("pdOutList", pdOutList);
		
		return "outReg";
	}
	
	@RequestMapping("/outReg/delete")
	public String deleteInReg(
			Model model,
			@RequestParam("chkValue") String chkValue
	) {
		
		System.out.println("chkValue : " + chkValue);
		
		int result = outRegService.deleteOutReg(chkValue);
		return "redirect:/outReg";
	}
}
