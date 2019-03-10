package com.cahodental.admin.controller;

import com.cahodental.admin.common.Result;
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
    public Result saveShop(ShopPO shopPO) {
        Result<Map<String, Object>> result = new Result<>();
        result.setStatus(-1);
        if (ObjectUtils.isEmpty(shopPO)) {
            result.setMessage("请检查参数");
            return result;
        }
        try {
            Map<String, Object> resMap = shopService.saveShop(shopPO);
            result.setData(resMap);
            result.setStatus(1);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            logger.error("ShopController.saveShop Exception", e);
        }
        return result;
    }

    @RequestMapping(value = "/updateShop", method = RequestMethod.POST)
    public Result updateShop(ShopPO shopPO) {
        Result<Map<String, Object>> result = new Result<>();
        result.setStatus(-1);
        if (ObjectUtils.isEmpty(shopPO)) {
            result.setMessage("请检查参数");
            return result;
        }
        if (StringUtils.isEmpty(shopPO.getId())) {
            result.setMessage("请检查参数id");
            return result;
        }
        try {
            Map<String, Object> resMap = shopService.updateShop(shopPO);
            result.setData(resMap);
            result.setStatus(1);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            logger.error("ShopController.updateShop Exception", e);
        }
        return result;
    }

    @RequestMapping(value = "/getShop", method = RequestMethod.GET)
    public Result getShop(Long id) {
        Result<Map<String, Object>> result = new Result<>();
        result.setStatus(-1);
        if (StringUtils.isEmpty(id)) {
            result.setMessage("请检查参数id");
            return result;
        }
        try {
            Map<String, Object> resMap = shopService.getShopById(id);
            result.setData(resMap);
            result.setStatus(1);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            logger.error("ShopController.getShop Exception", e);
        }
        return result;
    }

    @RequestMapping(value = "/listShops", method = RequestMethod.GET)
    public Result listShops(Boolean isPage, Integer pageNum, Integer pageSize) {
        Result<Map<String, Object>> result = new Result<>();
        result.setStatus(-1);
        if (StringUtils.isEmpty(isPage)) {
            result.setMessage("请检查参数isPage");
            return result;
        }
        if (isPage) {
            if ((pageNum < 1 || pageSize < 1)) {
                result.setMessage("请检查参数pageNum或pageSize");
                return result;
            }
        }
        try {
            Map<String, Object> resMap = shopService.listShops(isPage, pageNum, pageSize);
            result.setData(resMap);
            result.setStatus(1);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            logger.error("ShopController.getShop Exception", e);
        }
        return result;
    }
}
