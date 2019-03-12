package com.cahodental.admin.service.impl;

/*
 * Created by plumre on 2019/3/5.
 */

import com.cahodental.admin.dao.UserMapper;
import com.cahodental.admin.dao.VipCardMapper;
import com.cahodental.admin.model.po.UserPO;
import com.cahodental.admin.model.po.VipCardPO;
import com.cahodental.admin.model.vo.UserVO;
import com.cahodental.admin.service.UserService;
import com.cahodental.admin.util.IdGenerator;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author plumre
 * @version 1.0
 * @date 2019/3/5 14:58
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final VipCardMapper vipCardMapper;
    private IdGenerator idGenerator = new IdGenerator(1L, 1L);


    @Autowired
    public UserServiceImpl(UserMapper userMapper, VipCardMapper vipCardMapper) {
        this.userMapper = userMapper;
        this.vipCardMapper = vipCardMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> saveUser(UserVO userVO) {
        Map<String, Object> dataMap = new HashMap<>(16);
        long id = idGenerator.nextId();

        // 保存用户信息
        UserPO userPO = new UserPO();
        userPO.setId(id);
        userPO.setName(userVO.getName());
        userPO.setAge(userVO.getAge());
        userPO.setGender(userVO.getGender());
        userPO.setPhone(userVO.getPhone());
        userPO.setEmail(userVO.getEmail());
        userPO.setAddress(userVO.getAddress());
        userPO.setType(userVO.getType());
        userPO.setShopId(userVO.getShopId());
        userMapper.saveUser(userPO);

        // 保存用户关联的会员卡信息
        VipCardPO vipCardPO = new VipCardPO();
        vipCardPO.setId(id);
        vipCardPO.setBalance(BigDecimal.valueOf(0));
        vipCardPO.setCreateTime(new Date());
        vipCardMapper.saveVipCard(vipCardPO);

        dataMap.put("id", id);
        return dataMap;
    }

    @Override
    public Map<String, Object> deleteUser(Long id) {
        return null;

    }

    @Override
    public Map<String, Object> updateUser(UserVO userVO) {
        Map<String, Object> dataMap = new HashMap<>(16);
        // 更新用户信息
        UserPO userPO = new UserPO();
        userPO.setId(userVO.getId());
        userPO.setName(userVO.getName());
        userPO.setAge(userVO.getAge());
        userPO.setGender(userVO.getGender());
        userPO.setPhone(userVO.getPhone());
        userPO.setEmail(userVO.getEmail());
        userPO.setAddress(userVO.getAddress());
        userPO.setType(userVO.getType());
        userPO.setShopId(userVO.getShopId());
        userMapper.updateUser(userPO);
        dataMap.put("id", userVO.getId());
        return dataMap;
    }

    @Override
    public Map<String, Object> getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public Map<String, Object> getUserByName(String name) {
        Map<String, Object> dataMap = new HashMap<>(16);
        List<Map<String, Object>> list = userMapper.getUserByName(name);
        dataMap.put("list", list);
        return dataMap;
    }

    @Override
    public Map<String, Object> listUsersByShopId(Long shopId, Boolean isPage, Integer pageNum, Integer pageSize) {
        Map<String, Object> dataMap = new HashMap<>(16);
        if (isPage) {
            PageHelper.startPage(pageNum, pageSize);
        }
        List<Map<String, Object>> listMap = userMapper.listUsersByShopId(shopId);
        if (isPage) {
            Page<Map<String, Object>> list = (Page<Map<String, Object>>) listMap;
            dataMap.put("list", list);
            dataMap.put("total", list.getTotal());
            dataMap.put("pageNum", list.getPageNum());
        } else {
            dataMap.put("list", listMap);
        }
        return dataMap;
    }

    @Override
    public Map<String, Object> listUsers() {
        Map<String, Object> dataMap = new HashMap<>(16);
        List<Map<String, Object>> list = userMapper.listUsers();
        dataMap.put("list", list);
        return dataMap;
    }
}