package com.cahodental.admin.model.vo;

import com.cahodental.admin.model.po.VipCardPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    private Long id;
    private String name;
    private Integer age;
    private Integer gender;
    private String phone;
    private String email;
    private String address;
    private Character type;
    private Long shopId;
    private Date createTime;
    private Date updateTime;
    private VipCardPO vipCardPO;
}
