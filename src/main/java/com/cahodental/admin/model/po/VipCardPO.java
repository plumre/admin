package com.cahodental.admin.model.po;

/*
 * Created by renhongjiang on 2019/3/5.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/3/5 14:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VipCardPO {
    private Long id;
    private BigDecimal balance;
    private Date createTime;
    private Date updateTime;

}