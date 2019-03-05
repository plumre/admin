package com.cahodental.admin.model.po;

/*
 * Created by renhongjiang on 2019/3/5.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
public class ShopPO {
    private Long id;
    private String name;
    private Boolean isOpen;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date openingDay;
    private String phone;
    private String email;
    private String address;
    private Date createTime;
    private Date updateTime;

}