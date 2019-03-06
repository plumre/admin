package com.cahodental.admin.service.impl;

/*
 * Created by plumre on 2019/3/5.
 */

import com.cahodental.admin.model.po.OrderInfoPO;
import com.cahodental.admin.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * TODO
 *
 * @author plumre
 * @version 1.0
 * @date 2019/3/5 15:00
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Map<String, Object> saveOrderInfo(OrderInfoPO orderInfoPO) {
        return null;
    }

    @Override
    public Map<String, Object> deleteOrderInfo(Long id) {
        return null;
    }

    @Override
    public Map<String, Object> updateOrderInfo(OrderInfoPO orderInfoPO) {
        return null;
    }

    @Override
    public Map<String, Object> updateOrderStatus(Long id, Integer isPay) {
        return null;
    }

    @Override
    public Map<String, Object> getOrderInfoById(Long id) {
        return null;
    }

    @Override
    public Map<String, Object> listOrderInfos() {
        return null;
    }
}