package com.cahodental.admin.service;

/*
 * Created by renhongjiang on 2019/3/5.
 */

import com.cahodental.admin.model.po.UserPO;

/**
 * 客户信息的DAO接口
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/3/5 14:56
 */
public interface UserService {

    void saveUser(UserPO userPO);

}