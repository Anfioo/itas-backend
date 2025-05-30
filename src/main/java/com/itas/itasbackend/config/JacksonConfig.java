package com.itas.itasbackend.config;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
            // 注册Java 8日期时间模块
            builder.modules(new JavaTimeModule());
            // 禁用日期作为时间戳的序列化方式
            builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            // 设置全局日期格式（可选）
            builder.simpleDateFormat("yyyy-MM-dd HH:mm:ss");
        };
    }
}