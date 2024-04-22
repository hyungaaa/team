package com.spring.lee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	
	@RequestMapping(value="/inReg/search", method=RequestMethod.GET)
	public String listInRegPd2(
			@RequestParam("searchInput") String searchInput,
			Model model) {
		
		System.out.println("searchInput : " + searchInput);
		List pdList = inRegService.listPd(searchInput);
		List pdInList = inRegService.listPdin();
		
		
		System.out.println("controller > listInRegPd2 pdList : " + pdList);
		System.out.println("controller > listInRegPd2 pdInList : " + pdInList);
		
		System.out.println("pdList.size() : " + pdList.size());
		System.out.println("pdInList.size() : " + pdInList.size());
		
		model.addAttribute("pdList", pdList);
		model.addAttribute("pdInList", pdInList);
		
		return "inReg";
	}
	
	@RequestMapping("/inReg/insert")
	public String insertInReg(
			Model model,
			@ModelAttribute PdDTO pdDTO,
			@ModelAttribute Pd_inDTO pdinDTO
	) {
		
		JoinedDTO joinedDTO = new JoinedDTO();
		joinedDTO.setPd_inDTO(pdinDTO);
		joinedDTO.setPdDTO(pdDTO);
		System.out.println("joinedDTO : " + joinedDTO);
		
		System.out.println("pdDTO : " + pdDTO);
		System.out.println("pdinDTO : " + pdinDTO);
		
		System.out.println("joinedDTO.pdDTO.pnum : " + joinedDTO.getPdDTO().getPnum());
		System.out.println("pdDTO.getPnum() : " + pdDTO.getPnum());
		
		int result = inRegService.insertInReg(joinedDTO);
		System.out.println("insert : " + result);
		
		System.out.println();
		
		return "redirect:/inReg";
	}
	
	@RequestMapping("/inReg/update")
	public String updateInReg(
			Model model,
			@ModelAttribute PdDTO pdDTO,
			@ModelAttribute Pd_inDTO pdinDTO,
			@RequestParam("chkValue") String chkValue
	) {
		
		System.out.println("chkValue : " + chkValue);
		return "redirect:/inReg";
	}
}
