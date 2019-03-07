package com.cahodental.admin.controller;

import com.cahodental.admin.model.po.ShopPO;
import com.cahodental.admin.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }


    @RequestMapping(value = "/saveShop", method = RequestMethod.POST)
    public Map<String, Object> saveShop(ShopPO shopPO) {
        Map<String, Object> resMap = new HashMap<>(16);
        try {
            resMap = shopService.saveShop(shopPO);
            resMap.put("status", 1);
            return resMap;
        } catch (Exception e) {
            resMap.put("status", -1);
            resMap.put("message", e.getMessage());
            logger.error("ShopController.saveShop Exception", e);
            return resMap;
        }
    }

    @RequestMapping(value = "/updateShop", method = RequestMethod.POST)
    public Map<String, Object> updateShop(ShopPO shopPO) {
        Map<String, Object> resMap = new HashMap<>(16);
        if (ObjectUtils.isEmpty(shopPO)) {
            resMap.put("ww", null);
            return resMap;
        }
        if (StringUtils.isEmpty(shopPO.getId())) {
            return resMap;
        }
        try {
            resMap = shopService.updateShop(shopPO);
            resMap.put("status", 1);
            return resMap;
        } catch (Exception e) {
            resMap.put("status", -1);
            resMap.put("message", e.getMessage());
            logger.error("ShopController.updateShop Exception", e);
            return resMap;
        }
    }

    @RequestMapping(value = "/getShop", method = RequestMethod.GET)
    public Map<String, Object> getShop(Long id) {
        Map<String, Object> resMap = new HashMap<>(16);
        try {
            resMap = shopService.getShopById(id);
            resMap.put("status", 1);
            return resMap;
        } catch (Exception e) {
            resMap.put("status", -1);
            resMap.put("message", e.getMessage());
            logger.error("ShopController.getShop Exception", e);
            return resMap;
        }
    }

    @RequestMapping(value = "/listShops", method = RequestMethod.GET)
    public Map<String, Object> listShops(Boolean isPage, Integer pageNum, Integer pageSize) {
        Map<String, Object> resMap = new HashMap<>(16);
        try {
            resMap = shopService.listShops(isPage, pageNum, pageSize);
            resMap.put("status", 1);
            return resMap;
        } catch (Exception e) {
            resMap.put("status", -1);
            resMap.put("message", e.getMessage());
            logger.error("ShopController.getShop Exception", e);
            return resMap;
        }
    }
}
