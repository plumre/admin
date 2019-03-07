package com.cahodental.admin.service.impl;

/*
 * Created by plumre on 2019/3/5.
 */

import com.cahodental.admin.dao.AdminMapper;
import com.cahodental.admin.model.po.AdminPO;
import com.cahodental.admin.service.AdminService;
import com.cahodental.admin.util.IdGenerator;
import com.cahodental.admin.util.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author plumre
 * @version 1.0
 * @date 2019/3/5 15:00
 */
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;
    private IdGenerator idGenerator = new IdGenerator(1L, 1L);


    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }


    @Override
    public Map<String, Object> saveAdmin(AdminPO adminPO) {
        Map<String, Object> dataMap = new HashMap<>(16);
        adminPO.setId(idGenerator.nextId());
        adminPO.setPassword(Md5Utils.getPassword(adminPO.getPassword()));
        adminMapper.saveAdmin(adminPO);
        dataMap.put("id", adminPO.getId());
        return dataMap;
    }

    @Override
    public Map<String, Object> deleteAdmin(Long id) {
        return null;
    }

    @Override
    public Map<String, Object> updateAdmin(AdminPO adminPO) {
        Map<String, Object> dataMap = new HashMap<>(16);
        adminMapper.updateAdmin(adminPO);
        dataMap.put("id", adminPO.getId());
        return dataMap;
    }

    @Override
    public Map<String, Object> getAdminById(Long id) {
        return adminMapper.getAdminById(id);
    }

    @Override
    public Map<String, Object> getAdminByPassword(String userName, String password) {
        return adminMapper.getAdminByPassword(userName, password);
    }

    @Override
    public Map<String, Object> listAdmins() {
        return null;
    }
}