package com.cahodental.admin.service.impl;

/*
 * Created by renhongjiang on 2019/3/5.
 */

import com.cahodental.admin.dao.UserMapper;
import com.cahodental.admin.dao.VipCardMapper;
import com.cahodental.admin.model.po.UserPO;
import com.cahodental.admin.model.po.VipCardPO;
import com.cahodental.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/3/5 14:58
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private VipCardMapper vipCardMapper;

    @Override
    public void saveUser(UserPO userPO) {
        VipCardPO vipCardPO = new VipCardPO();
        vipCardPO.setId((long) 1);
        vipCardPO.setBalance(BigDecimal.valueOf(100));
        vipCardPO.setCreateTime(new Date());
        vipCardMapper.saveVipCard(vipCardPO);
    }
}