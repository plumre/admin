package com.cahodental.admin.service;

/*
 * Created by plumre on 2019/3/5.
 */

import com.cahodental.admin.model.po.UserPO;
import com.cahodental.admin.model.vo.UserVO;

import java.util.Map;

/**
 * 客户信息的Service接口
 *
 * @author plumre
 * @version 1.0
 * @date 2019/3/5 14:56
 */
public interface UserService {

    /**
     * 新增客户信息
     *
     * @param userVO 客户对象
     */
    Map<String, Object> saveUser(UserVO userVO);

    /**
     * 删除客户信息
     *
     * @param id 客户的id
     */
    Map<String, Object> deleteUser(Long id);

    /**
     * 更新客户的信息
     *
     * @param userVO 客户对象
     */
    Map<String, Object> updateUser(UserVO userVO);

    /**
     * 根据id获取客户信息，适用于用户信息的编辑按钮处
     *
     * @param id 客户id
     * @return 客户信息键值对Map
     */
    Map<String, Object> getUserById(Long id);

    /**
     * 通过姓名检索客户，有可能重名。所以返回结果设为List
     *
     * @param name 客户姓名
     * @return 客户的信息集合，多数情况集合的元素个数为1；当出现重名客户时，元素个数大于1
     */
    Map<String, Object> getUserByName(String name);

    /**
     * 根据shopId获取当前店铺的客户信息
     *
     * @param shopId 店铺id
     * @return 客户信息的集合
     */
    Map<String, Object> listUsersByShopId(Long shopId, Boolean isPage, Integer pageNum, Integer pageSize);

    /**
     * 获取所有店铺的客户信息
     *
     * @return 客户信息的集合
     */
    Map<String, Object> listUsers();

}