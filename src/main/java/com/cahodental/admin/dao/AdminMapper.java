package com.cahodental.admin.dao;

/*
 * Created by renhongjiang on 2019/3/5.
 */

import com.cahodental.admin.model.po.AdminPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 店铺管理员信息的DAO接口
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/3/5 14:38
 */
@Repository
public interface AdminMapper {

    /**
     * 新增管理员信息
     *
     * @param adminPO 管理员对象
     */
    void saveAdmin(AdminPO adminPO);

    /**
     * 删除管理员信息
     *
     * @param id 管理员id
     */
    void deleteAdmin(Long id);

    /**
     * 更新管理员信息
     *
     * @param adminPO 管理员对象
     */
    void updateAdmin(AdminPO adminPO);

    /**
     * 根据id获取管理员信息，适用于管理员信息的编辑按钮处
     *
     * @param id 管理员id
     * @return 管理员信息
     */
    Map<String, Object> getAdminById(Long id);

    /**
     * 根据用户名和密码获取管理员信息，适用于登录按钮处
     *
     * @param userName 用户名
     * @param password 密码
     * @return 管理员信息，如果账户密码不匹配，则获取为空
     */
    Map<String, Object> getAdminByPassword(@Param("userName") String userName, @Param("password") String password);

    /**
     * 列出所有店铺的管理员信息
     *
     * @return 管理员信息集合
     */
    List<Map<String, Object>> listAdmins();

}