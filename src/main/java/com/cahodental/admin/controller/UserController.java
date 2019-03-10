package com.cahodental.admin.controller;

import com.cahodental.admin.common.Result;
import com.cahodental.admin.model.vo.UserVO;
import com.cahodental.admin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public Result saveUser(UserVO userVO) {
        Result<Map<String, Object>> result = new Result<>();
        result.setStatus(-1);
        try {
            Map<String, Object> resMap = userService.saveUser(userVO);
            result.setData(resMap);
            result.setStatus(1);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            logger.error("ShopController.saveShop Exception", e);
        }
        return result;
    }


    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public Result getUser(Long id) {
        Result<Map<String, Object>> result = new Result<>();
        result.setStatus(-1);
        if (StringUtils.isEmpty(id)) {
            result.setMessage("请检查参数id");
            return result;
        }
        try {
            Map<String, Object> resMap = userService.getUserById(id);
            result.setData(resMap);
            result.setStatus(1);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            logger.error("UserController.getUser Exception", e);
        }
        return result;
    }


}
