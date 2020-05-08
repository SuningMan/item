package com.kuang.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: lqs
 * @Date: 2020/2/25 13:43
 */
@SpringBootApplication
@MapperScan(value = {"com.kuang.edu.dao"})
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
}
