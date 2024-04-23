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
	
	@RequestMapping("/outReg/insert")
	public String insertInReg(
			Model model,
			@ModelAttribute PdDTO pdDTO,
			@ModelAttribute Pd_inDTO pdinDTO,
			@ModelAttribute Pd_outDTO pdoutDTO
	) {
		
		JoinedDTO joinedDTO = new JoinedDTO();
		joinedDTO.setPdDTO(pdDTO);
		joinedDTO.setPd_inDTO(pdinDTO);
		joinedDTO.setPd_outDTO(pdoutDTO);
		System.out.println("joinedDTO : " + joinedDTO);
		
		System.out.println("pdDTO : " + pdDTO);
		System.out.println("pdinDTO : " + pdinDTO);
		System.out.println("pdoutDTO : " + pdoutDTO);
		
		System.out.println("joinedDTO.pdDTO.pnum : " + joinedDTO.getPdDTO().getPnum());
		System.out.println("pdDTO.getPnum() : " + pdDTO.getPnum());
		System.out.println("pdinDTO.getPlot() : " + pdinDTO.getPlot());
		System.out.println("pdoutDTO.getPeoutcnt() : " + pdoutDTO.getPoutcnt());
		
		int result = outRegService.insertOutReg(joinedDTO);
		System.out.println("out insert : " + result);
		
		return "redirect:/outReg";
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
