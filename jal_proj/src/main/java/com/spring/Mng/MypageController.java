package com.spring.Mng;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MypageController {

	@Autowired
	private MypageDAO mypageDAO;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			public void setAsText(String text) {
				try {
					setValue(new SimpleDateFormat("yyyy-MM-dd").parse(text));
				} catch (java.text.ParseException e) {
					setValue(null);
				}
			}
		});
	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String home(HttpSession session, Model model) {
		String uuid = (String) session.getAttribute("uuid"); // 세션에서 uuid 가져오기
		if (uuid != null) {
			MypageDTO user = mypageDAO.selectmyPageUserInfo(uuid); // 해당 uuid의 사용자 정보 조회
			model.addAttribute("myPageUserInfo", user);
		}
		return "mypage";
	}

	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
	@Transactional
	public String updateUserInfo(@ModelAttribute("myPageUserInfo") MypageDTO myPageUserInfo, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			// 에러 출력
			System.out.println("Form errors: " + result.getAllErrors());
			return "mypage";
		}
		System.out.println("Updating user: " + myPageUserInfo);
		int updatedRows = mypageDAO.updateUserInfo(myPageUserInfo);
		System.out.println("Updated rows: " + updatedRows);
		return "redirect:/mypage";
	}

}
