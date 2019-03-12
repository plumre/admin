package com.cahodental.admin.dao;

/*
 * Created by plumre on 2019/3/5.
 */

import com.cahodental.admin.model.po.OrderInfoPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 订单信息的DAO接口
 *
 * @author plumre
 * @version 1.0
 * @date 2019/3/5 14:38
 */
@Repository
public interface OrderInfoMapper {

    /**
     * 新增订单信息
     *
     * @param orderInfoPO 订单对象
     */
    void saveOrderInfo(OrderInfoPO orderInfoPO);

    /**
     * 删除订单信息
     *
     * @param id
     */
    void deleteOrderInfo(Long id);

    /**
     * 更新订单信息
     *
     * @param orderInfoPO
     */
    void updateOrderInfo(OrderInfoPO orderInfoPO);

    /**
     * 更新订单状态，通常为支付状态的更改
     *
     * @param id    订单id
     * @param isPay 支付状态
     */
    void updateOrderStatus(@Param("id") Long id, @Param("isPay") Boolean isPay);

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
    List<Map<String, Object>> listOrderInfos();

}