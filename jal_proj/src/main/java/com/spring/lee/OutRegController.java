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
		// select 맨위에
		List pdList = outRegService.listPd();
		// 팝업에 떠야 할 list
		List pdOutList = outRegService.listPdout();
		
		System.out.println("out> pdList : " + pdList);
		System.out.println("out> pdOutList : " + pdOutList);
		
		model.addAttribute("pdList", pdList);
		model.addAttribute("pdOutList", pdOutList);
		
		return "outReg";
	}
	
	@RequestMapping(value="/outReg/search", method=RequestMethod.GET)
	public String listInRegPd2(
			@RequestParam("searchInput") String searchInput,
			Model model) {
		
		System.out.println("검색어 searchInput : " + searchInput);
		
		// 검색어 ㄱㄱ
		List pdList2 = outRegService.listPdout(searchInput);
		
		// 팝업에 떠야 할 list
		List pdOutList = outRegService.listPdout();
		
		System.out.println("out/search> pdListSearch : " + pdList2);
		System.out.println("out/search> pdOutListList : " + pdOutList);
		
		model.addAttribute("pdList2", pdList2);
		model.addAttribute("pdOutList", pdOutList);
		
		return "redirect:/outReg";
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
		
		return "outReg";
	}
	
	@RequestMapping("/outReg/update")
	public String updateOutReg(
			Model model,
			@RequestParam("chkValue") String chkValue
	) {
		
		System.out.println("chkValue : " + chkValue);
		
		int result = outRegService.updateOutReg(chkValue);
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
