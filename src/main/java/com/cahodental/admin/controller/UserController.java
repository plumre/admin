package com.cahodental.admin.controller;

import com.cahodental.admin.model.vo.UserVO;
import com.cahodental.admin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public Map<String, Object> saveUser(UserVO userVO) {
        Map<String, Object> resMap = new HashMap<>(16);
        try {
            resMap = userService.saveUser(userVO);
            resMap.put("status", 1);
            return resMap;
        } catch (Exception e) {
            resMap.put("status", -1);
            resMap.put("message", e.getMessage());
            logger.error("ShopController.saveShop Exception", e);
            return resMap;
        }
    }


    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public Map<String, Object> getUser(Long id) {
        Map<String, Object> resMap = new HashMap<>(16);
        if (StringUtils.isEmpty(id)) {
            return resMap;
        }
        try {
            resMap = userService.getUserById(id);
            resMap.put("status", 1);
            return resMap;
        } catch (Exception e) {
            resMap.put("status", -1);
            resMap.put("message", e.getMessage());
            logger.error("UserController.getUser Exception", e);
            return resMap;
        }
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.GET)
    public Map<String, Object> loginUser(String name, String password) {
        Map<String, Object> resMap = new HashMap<>(16);
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            return resMap;
        }
        try {
            resMap = userService.getUserByName(name);
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
