package com.wencheng.wencheng_web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.wencheng.wencheng_web.Mapper")
//@EnableCaching
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class WenchengWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run ( WenchengWebApplication.class, args );
    }



}
