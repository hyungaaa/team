package com.spring.y_02;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardListController {
	
	@Autowired
	BoardListService boardListService;
	
	// select
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public String selectList(Model model) {
		List list = boardListService.selectList();
		if(list != null) {
			System.out.println("boardlist.size : " + list.size());
		}
		model.addAttribute("list", list);
		return "board";
	}
	
	// selected
	@RequestMapping(value="/board", method = RequestMethod.GET)
	public String selectedView(
			@RequestParam("bno") int bno,
			Model model
			) {
		BoardListDTO dto = new BoardListDTO();
		dto.setBno(bno);
		
		List list = boardListService.selectedView(dto);
		model.addAttribute("boardList", list);
		System.out.println("boardlist : " + list);
		return "boardSelect";
	}
	
	// insert
	@RequestMapping("/boardWrite2")
	public String insertBd(
			@RequestParam("btitle") String btitle,
			@RequestParam("btext") String btext
	) {
		BoardListDTO dto = new BoardListDTO();
		dto.setBtitle(btitle);
		dto.setBtext(btext);
		
		System.out.println("btitle : " + btitle);
		
		int result = boardListService.insertBd(dto);
		System.out.println("result : " + result);
		return "redirect:/boardList";
	}
	
	@RequestMapping("/boardWrite")
	public String text() {
		return "boardWrite";
	}
}
