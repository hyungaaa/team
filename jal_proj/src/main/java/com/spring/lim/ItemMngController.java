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
	public String selectList2(Model model) {
		List list = itMngService.selectList2();
		if(list != null) {
			System.out.println("list.size : " + list.size());
		}
		model.addAttribute("list", list);
		return "item2";
	}

	@RequestMapping(value = "/itemMng3", method = RequestMethod.GET)
	public String selectList3(Model model) {
		List list = itMngService.selectList3();
		if(list != null) {
			System.out.println("list.size : " + list.size());
		}
		model.addAttribute("list", list);
		return "item3";
	}
	@RequestMapping(value = "/itemMng4", method = RequestMethod.GET)
	public String selectList4(Model model) {
		List list = itMngService.selectList4();
		if(list != null) {
			System.out.println("list.size : " + list.size());
		}
		model.addAttribute("list", list);
		return "item4";
	}
	@RequestMapping(value = "/itemMng5", method = RequestMethod.GET)
	public String selectList5(Model model) {
		List list = itMngService.selectList5();
		if(list != null) {
			System.out.println("list.size : " + list.size());
		}
		model.addAttribute("list", list);
		return "item5";
	}


}
