package com.cahodental.admin.dao;

/*
 * Created by plumre on 2019/3/5.
 */

import com.cahodental.admin.model.po.VipCardPO;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * 会员卡信息的DAO接口
 *
 * @author plumre
 * @version 1.0
 * @date 2019/3/5 14:38
 */
@Repository
public interface VipCardMapper {

    /**
     * 新增会员卡信息
     *
     * @param vipCardPO 会员卡对象
     */
    void saveVipCard(VipCardPO vipCardPO);

    /*void deleteVIPCard(Long id);*/

    /**
     * 更新会员卡信息
     *
     * @param vipCardPO 会员卡对象
     */
    void updateVipCard(VipCardPO vipCardPO);


    /**
     * 查询会员卡余额信息
     * @param userId 客户id
     * @return 余额
     */
    BigDecimal getBalance(Long userId);
}