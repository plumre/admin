package com.cahodental.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot主启动类
 *
 * @author renhongjiang
 * @date 2019/3/5 13:37
 */
@MapperScan("com.cahodental.admin.dao")
@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
