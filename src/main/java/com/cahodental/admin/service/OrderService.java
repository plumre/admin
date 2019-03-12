package com.cahodental.admin.service;

/*
 * Created by plumre on 2019/3/5.
 */

import com.cahodental.admin.model.po.OrderInfoPO;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 订单信息的Service接口
 *
 * @author plumre
 * @version 1.0
 * @date 2019/3/5 14:57
 */
public interface OrderService {

    Map<String, Object> saveOrderInfo(OrderInfoPO orderInfoPO);

    /**
     * 删除订单信息
     *
     * @param id
     */
    Map<String, Object> deleteOrderInfo(Long id);

    /**
     * 更新订单信息
     *
     * @param orderInfoPO
     */
    Map<String, Object> updateOrderInfo(OrderInfoPO orderInfoPO);

    /**
     * 更新订单状态，通常为支付状态的更改
     *
     * @param id    订单id
     * @param isPay 支付状态
     */
    Map<String, Object> updateOrderStatus(Long id, Boolean isPay, Long userId, BigDecimal vipCardBalance, Long referer, BigDecimal bonus);

    /**
     * 根据id获取订单信息，适用于订单编辑处按钮、查看订单按钮
     *
     * @param id 订单id
     * @return 订单信息
     */
    Map<String, Object> getOrderInfoById(Long id);

    /**
     * 列出所有店铺的订单信息
     *
     * @return 订单信息集合
     */
    Map<String, Object> listOrderInfos();

}