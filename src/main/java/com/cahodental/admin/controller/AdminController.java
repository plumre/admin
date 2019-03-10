package com.cahodental.admin.controller;

import com.cahodental.admin.common.Result;
import com.cahodental.admin.model.po.AdminPO;
import com.cahodental.admin.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @RequestMapping(value = "/saveAdmin", method = RequestMethod.POST)
    public Result saveAdmin(AdminPO adminPO) {
        Result<Map<String, Object>> result = new Result<>();
        result.setStatus(-1);
        if (ObjectUtils.isEmpty(adminPO)) {
            result.setMessage("请检查参数");
            return result;
        }
        try {
            Map<String, Object> resMap = adminService.saveAdmin(adminPO);
            result.setStatus(1);
            result.setData(resMap);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            logger.error("AdminController.saveAdmin Exception", e);
        }
        return result;
    }


    @RequestMapping(value = "/loginAdmin", method = RequestMethod.GET)
    public Result loginAdmin(String name, String password) {
        Result<Map<String, Object>> result = new Result<>();
        result.setStatus(-1);
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            result.setMessage("请检查参数");
            return result;
        }
        try {
            Map<String, Object> resMap = adminService.getAdminByPassword(name, password);
            result.setData(resMap);
            result.setStatus(1);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            logger.error("AdminController.loginAdmin Exception", e);
        }
        return result;
    }
}
