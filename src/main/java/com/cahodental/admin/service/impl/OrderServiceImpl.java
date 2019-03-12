package com.cahodental.admin.service.impl;

/*
 * Created by plumre on 2019/3/5.
 */

import com.cahodental.admin.dao.OrderInfoMapper;
import com.cahodental.admin.dao.VipCardMapper;
import com.cahodental.admin.model.po.OrderInfoPO;
import com.cahodental.admin.model.po.VipCardPO;
import com.cahodental.admin.service.OrderService;
import com.cahodental.admin.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
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
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private VipCardMapper vipCardMapper;

    private IdGenerator idGenerator = new IdGenerator(1L, 1L);


    @Override
    public Map<String, Object> saveOrderInfo(OrderInfoPO orderInfoPO) {
        Map<String, Object> dataMap = new HashMap<>(16);
        long id = idGenerator.nextId();
        orderInfoPO.setId(id);
        orderInfoMapper.saveOrderInfo(orderInfoPO);
        BigDecimal orderAmount = orderInfoPO.getOrderAmount();
        // 判读是否参加促销活动
        dataMap.put("id", id);
        if (!orderInfoPO.getIsPromotion()) {
            BigDecimal vipCardBalance = vipCardMapper.getBalance(orderInfoPO.getUserId());
            dataMap.put("vipCardBalance", vipCardBalance);
            dataMap.put("userId", orderInfoPO.getUserId());
            dataMap.put("orderAmount", orderAmount);
            return dataMap;
        } else {
            // 参加活动的客户 一定是新客户 在后续支付页面中不会向后台传入vipCardBalance
            BigDecimal amountAfterDiscount = BigDecimal.valueOf(orderAmount.doubleValue() / 100 * orderInfoPO.getDiscount());
            dataMap.put("orderAmount", amountAfterDiscount);
            dataMap.put("referer", orderInfoPO.getReferer());
            dataMap.put("bonus", BigDecimal.valueOf(orderAmount.doubleValue() - amountAfterDiscount.doubleValue()));
            return dataMap;
        }
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
    public Map<String, Object> updateOrderStatus(Long id, Boolean isPay, Long userId, BigDecimal vipCardBalance, Long referer, BigDecimal bonus) {
        Map<String, Object> dataMap = new HashMap<>(16);
        orderInfoMapper.updateOrderStatus(id, isPay);
        dataMap.put("id", id);
        // 取消订单
        if (!isPay) {
            return dataMap;
        }
        // 成功支付
        // 判断传入userId还是referer 或者两者都不传
        // 1. 对客户的会员卡余额进行减额操作(前提是客户的vipCardBalance传入) -- userId
        // 2. 对推荐人的会员卡余额进行增额操作 -- referer
        VipCardPO vipCardPO = new VipCardPO();
        if (!StringUtils.isEmpty(userId)) {
            // 客户不使用会员卡余额支付
            if (StringUtils.isEmpty(vipCardBalance)) {
                return dataMap;
            }
            // 客户使用会员卡余额支付 进行减额操作
            vipCardPO.setId(userId);
            vipCardPO.setBalance(BigDecimal.valueOf(0));
            vipCardMapper.updateVipCard(vipCardPO);
        } else if (!StringUtils.isEmpty(referer)) {
            // 推荐人进行增额操作
            BigDecimal balance = vipCardMapper.getBalance(referer);
            vipCardPO.setId(referer);
            vipCardPO.setBalance(BigDecimal.valueOf(balance.doubleValue() + bonus.doubleValue()));
            vipCardMapper.updateVipCard(vipCardPO);
        }
        return dataMap;
    }

    @Override
    public Map<String, Object> getOrderInfoById(Long id) {
        Map<String, Object> dataMap = new HashMap<>(16);
        Map<String, Object> map = orderInfoMapper.getOrderInfoById(id);
        dataMap.put("map", map);
        return dataMap;
    }

    @Override
    public Map<String, Object> listOrderInfos() {
        Map<String, Object> dataMap = new HashMap<>(16);
        List<Map<String, Object>> mapList = orderInfoMapper.listOrderInfos();
        dataMap.put("map", mapList);
        return dataMap;
    }
}