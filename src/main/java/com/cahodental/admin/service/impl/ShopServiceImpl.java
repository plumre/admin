package com.cahodental.admin.service.impl;

/*
 * Created by plumre on 2019/3/5.
 */

import com.cahodental.admin.dao.ShopMapper;
import com.cahodental.admin.model.po.ShopPO;
import com.cahodental.admin.service.ShopService;
import com.cahodental.admin.util.IdGenerator;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author plumre
 * @version 1.0
 * @date 2019/3/5 15:00
 */
@Service
public class ShopServiceImpl implements ShopService {

    private final ShopMapper shopMapper;
    private IdGenerator idGenerator = new IdGenerator(1L, 1L);

    @Autowired
    public ShopServiceImpl(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }


    @Override
    public Map<String, Object> saveShop(ShopPO shopPO) {
        Map<String, Object> dataMap = new HashMap<>(16);
        shopPO.setId(idGenerator.nextId());
        shopMapper.saveShop(shopPO);
        dataMap.put("id", shopPO.getId());
        return dataMap;
    }

    @Override
    public Map<String, Object> deleteShop(Long id) {
        return null;
    }

    @Override
    public Map<String, Object> updateShop(ShopPO shopPO) {
        Map<String, Object> dataMap = new HashMap<>(16);
        shopMapper.updateShop(shopPO);
        dataMap.put("id", shopPO.getId());
        return dataMap;
    }

    @Override
    public Map<String, Object> getShopById(Long id) {
        return shopMapper.getShopById(id);
    }

    @Override
    public Map<String, Object> listShops(Boolean isPage, Integer pageNum, Integer pageSize) {
        Map<String, Object> dataMap = new HashMap<>(16);
        List<Map<String, Object>> listMap;
        if (isPage) {
            PageHelper.startPage(pageNum, pageSize);
            listMap = shopMapper.listShops();
            Page<Map<String, Object>> list = (Page<Map<String, Object>>) listMap;
            dataMap.put("list", list);
            dataMap.put("total", list.getTotal());
            dataMap.put("pageNum", list.getPageNum());
            return dataMap;
        } else {
            listMap = shopMapper.listShops();
            dataMap.put("list", listMap);
            return dataMap;
        }

    }
}