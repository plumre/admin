package com.cahodental.admin.model.po;

/*
 * Created by renhongjiang on 2019/3/5.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class UserPO {
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

}