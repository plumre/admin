package com.cahodental.admin.controller;

import com.cahodental.admin.model.po.ShopPO;
import com.cahodental.admin.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;


    @RequestMapping(value = "/saveShop", method = RequestMethod.POST)
    public Map<String, Object> saveShop(ShopPO shopPO, Model model) {
        Map<String, Object> resMap = new HashMap<>(16);
        try {
            resMap = shopService.saveShop(shopPO);
            resMap.put("status", 1);
            return resMap;
        } catch (Exception e) {
            resMap.put("status", -1);
            resMap.put("message", e.getMessage());
            return resMap;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getShop", method = RequestMethod.POST)
    public Map<String, Object> getShop(Long id) {
        Map<String, Object> resMap = new HashMap<>(16);
        try {
            resMap = shopService.getShopById(id);
            resMap.put("status", 1);
            return resMap;
        } catch (Exception e) {
            resMap.put("status", -1);
            resMap.put("message", e.getMessage());
            return resMap;
        }

    }
}
