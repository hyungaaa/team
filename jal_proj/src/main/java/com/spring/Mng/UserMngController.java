package com.spring.Mng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserMngController {

	@Autowired
	private UserMngService userMngService;
	@Autowired
	private UserMngDAO userMngDAO;
	@Autowired
	private UserMngDAO2 userMngDAO2;

	@RequestMapping(value = "/userMng", method = RequestMethod.GET)
	public String home(Model model) {
		List<UserMngDTO> infoPower = userMngDAO.selectInfoPower();
		List<UserMngDTO> centerList = userMngDAO.selectCenterList();
		List<UserMngDTO2> userInfo = userMngDAO2.selectUserInfo();
		List<UserMngDTO2> reqList = userMngDAO2.selectReqList();

		model.addAttribute("infoPower", infoPower);
		model.addAttribute("centerList", centerList);
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("reqList", reqList);

		return "userMng";
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	@Transactional
	public String deleteUser(@RequestParam("uuid") String uuid, RedirectAttributes redirectAttributes) {
		try {
			int affectedRows = userMngService.deleteUser(uuid);
			if (affectedRows > 0) {
				redirectAttributes.addFlashAttribute("message", "사용자가 성공적으로 삭제되었습니다.");
			} else {
				redirectAttributes.addFlashAttribute("errorMessage", "삭제할 사용자가 없거나 이미 삭제되었습니다.");
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", "사용자 삭제 과정에서 오류가 발생했습니다.");
		}
		return "redirect:/userMng";
	}

}
