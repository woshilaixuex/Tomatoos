package com.example;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@MapperScan("com.example.dao")
@ServletComponentScan
//@ComponentScan("com.example.config")
public class TomatooApplication {

    public static void main(String[] args) {
        SpringApplication.run(TomatooApplication.class, args);
        log.info("项目启动成功");
    }

}
