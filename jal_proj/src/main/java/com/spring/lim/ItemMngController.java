package com.spring.lim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ItemMngController {
	
	@Autowired
	ItMngService itMngService;
	
	@RequestMapping(value = "/itemMng", method = RequestMethod.GET)
	public String selectList(Model model) {
		List list = itMngService.selectList();
		if(list != null) {
			System.out.println("list.size : " + list.size());
		}
		model.addAttribute("list", list);
		return "item";
	}

	@RequestMapping(value = "/itemMng2", method = RequestMethod.GET)
	public String selectDetail(
			@RequestParam("scid") String scid,
			Model model
		){
		ItMngDTO dto = new ItMngDTO();
		dto.setScid(scid);
		
		System.out.println("scid : " + scid);
		List list = itMngService.selectList();
		if(list != null) {
			System.out.println("list.size : " + list.size());
		}
		model.addAttribute("list", list);
//		System.out.println("list: "+list);
		return "item";
	}
}
