package com.cahodental.admin.dao;

/*
 * Created by plumre on 2019/3/5.
 */

import com.cahodental.admin.model.po.ShopPO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 店铺信息的DAO接口
 *
 * @author plumre
 * @version 1.0
 * @date 2019/3/5 14:38
 */
@Repository
public interface ShopMapper {

    /**
     * 新增店铺信息
     *
     * @param shopPO 店铺对象
     */
    void saveShop(ShopPO shopPO);

    /**
     * 删除店铺信息
     *
     * @param id 店铺id
     */
    void deleteShop(Long id);

    /**
     * 更新店铺信息
     *
     * @param shopPO 店铺对象
     */
    void updateShop(ShopPO shopPO);

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
    List<Map<String, Object>> listShops();

}