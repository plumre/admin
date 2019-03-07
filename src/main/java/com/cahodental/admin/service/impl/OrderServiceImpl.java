package com.cahodental.admin.service.impl;

/*
 * Created by plumre on 2019/3/5.
 */

import com.cahodental.admin.dao.OrderInfoMapper;
import com.cahodental.admin.model.po.OrderInfoPO;
import com.cahodental.admin.service.OrderService;
import com.cahodental.admin.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    private IdGenerator idGenerator = new IdGenerator(1L, 1L);


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