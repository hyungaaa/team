package com.spring.Mng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserMngController {

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
}
