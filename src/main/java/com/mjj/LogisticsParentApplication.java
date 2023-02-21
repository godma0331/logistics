package com.mjj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.mjj.mapper")
public class LogisticsParentApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogisticsParentApplication.class, args);
    }

}
