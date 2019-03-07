package com.cahodental.admin.controller;

import com.cahodental.admin.model.po.AdminPO;
import com.cahodental.admin.model.vo.UserVO;
import com.cahodental.admin.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    public static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public Map<String, Object> saveAdmin(AdminPO adminPO) {
        Map<String, Object> resMap = new HashMap<>(16);
        try {
            resMap = adminService.saveAdmin(adminPO);
            resMap.put("status", 1);
            return resMap;
        } catch (Exception e) {
            resMap.put("status", -1);
            resMap.put("message", e.getMessage());
            logger.error("ShopController.saveShop Exception", e);
            return resMap;
        }
    }


    @RequestMapping(value = "/loginAdmin", method = RequestMethod.GET)
    public Map<String, Object> loginAdmin(String name, String password) {
        Map<String, Object> resMap = new HashMap<>(16);
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            return resMap;
        }
        try {
            resMap = adminService.getAdminByPassword(name, password);
            resMap.put("status", 1);
            return resMap;
        } catch (Exception e) {
            resMap.put("status", -1);
            resMap.put("message", e.getMessage());
            logger.error("UserController.getUser Exception", e);
            return resMap;
        }
    }
}
