package com.example.springbootsecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springbootsecurity.mapper")
public class SpringbootSecurityApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootSecurityApplication.class, args);
    }

}
