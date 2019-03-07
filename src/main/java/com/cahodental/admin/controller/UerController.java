package com.cahodental.admin.controller;

import com.cahodental.admin.model.po.UserPO;
import com.cahodental.admin.model.vo.UserVO;
import com.cahodental.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UerController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUser(Model model) {
        System.out.println("UerController.getUser");
        model.addAttribute("msg","this message is from Model.");
        return "/login";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(Model model) {
        System.out.println("UerController.addUser");
        model.addAttribute("msg","this message is from Model AddUser.");
        return "/login.html";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(UserVO userVO, Model model) {
        System.out.println("UerController.save");
        userService.saveUser(userVO);
        System.out.println("model = " + model);
        model.addAttribute("msg","this message is from Model AddUser.");
        return "/login.html";
    }
}
