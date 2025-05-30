package com.itas.itasbackend.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:7765") // 或前端实际域名
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 必须包含 OPTIONS
                .allowedHeaders("*")
                .exposedHeaders("Authorization") // 关键：允许前端读取
                .allowCredentials(true);
    }
}
