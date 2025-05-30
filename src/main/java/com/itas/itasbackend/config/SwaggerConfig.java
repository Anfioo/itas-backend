package com.itas.itasbackend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Anfioo 后台接口文档")
                        .version("1.0.0")
                        .description("这是 Anfioo 项目的后台管理接口文档。")
                        .contact(new Contact()
                                .name("你的名字或公司")
                                .email("3485977506@qq.com")
                                .url("https://www.example.com")
                        )
                );
    }
}
