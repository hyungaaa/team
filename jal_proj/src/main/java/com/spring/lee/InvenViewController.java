package com.spring.lee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InvenViewController {
	
	@Autowired
	InvenViewService invenViewService;
	
	// select
	@RequestMapping("/invenView")
	public String selectInven(Model model) {
		List list = invenViewService.selectInven();
		if(list != null) {
			System.out.println("inven.size : " + list.size());
		}
		model.addAttribute("list", list);
		return "invent";
	}
	
	// update
	@RequestMapping(value="/invenFix", method = RequestMethod.POST)
	public String updateInven(
			@RequestParam("icnt") int icnt,
			@RequestParam("ire") String ire,
			@RequestParam("plot") String plot
			) {
		System.out.println("controller 들어옴22");
		InvenDTO2 dto = new InvenDTO2();
		dto.setIcnt(icnt);
		dto.setIre(ire);
		dto.setPlot(plot);
		System.out.println("inven dto : "+ dto);
		int result = invenViewService.updateInven(dto);
		System.out.println("update 결과 : " + result);
		
		return "redirect:/invenView";
	}
}
