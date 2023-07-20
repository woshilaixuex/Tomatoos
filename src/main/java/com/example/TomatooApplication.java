package com.example;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.example.dao")
public class TomatooApplication {

    public static void main(String[] args) {
        SpringApplication.run(TomatooApplication.class, args);
        log.info("项目启动成功");
    }

}
