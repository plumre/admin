package com.cahodental.admin.service;

/*
 * Created by plumre on 2019/3/5.
 */

import com.cahodental.admin.model.po.ShopPO;

import java.util.Map;

/**
 * 店铺信息的Service接口
 *
 * @author plumre
 * @version 1.0
 * @date 2019/3/5 14:58
 */
public interface ShopService {

    /**
     * 新增店铺信息
     *
     * @param shopPO 店铺对象
     * @return 保存店铺对象成功后，返回店铺id
     */
    Map<String, Object> saveShop(ShopPO shopPO);

    /**
     * 删除店铺信息
     *
     * @param id 店铺id
     * @return 删除店铺对象成功后，返回店铺id
     */
    Map<String, Object> deleteShop(Long id);

    /**
     * 更新店铺信息
     *
     * @param shopPO 店铺对象
     * @return 更新店铺对象成功后，返回店铺id
     */
    Map<String, Object> updateShop(ShopPO shopPO);

    /**
     * 根据id获取店铺信息
     *
     * @param id 店铺id
     * @return 店铺信息
     */
    Map<String, Object> getShop(Long id);

    /**
     * 列出所有店铺信息
     *
     * @return 店铺信息集合
     */
    Map<String, Object> listShops();

}