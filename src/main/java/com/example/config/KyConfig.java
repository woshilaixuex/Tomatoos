package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class KyConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                System.out.println("core");
                //添加映射路径
                registry.addMapping("/**")
                        //允许的域
                        .allowedOrigins("http://localhost:8090/")
                        //是否允许携带cookie，跨域这里填true会报错
                        .allowCredentials(false)
                        //允许的请求方式
                        .allowedMethods("GET","POST","PUT","DELETE")
                        //允许的请求头
                        .allowedHeaders("*");
            }
        };
    }
}
