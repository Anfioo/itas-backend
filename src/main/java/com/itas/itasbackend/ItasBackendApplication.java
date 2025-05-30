package com.itas.itasbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itas.itasbackend.mapper")
public class ItasBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItasBackendApplication.class, args);
    }

}
