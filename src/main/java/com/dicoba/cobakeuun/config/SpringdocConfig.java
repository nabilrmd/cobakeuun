package com.dicoba.cobakeuun.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class SpringdocConfig implements WebMvcConfigurer {

    @Bean
    public OpenAPI customOpenAPi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Test Springdoc Swagger 3.0")
                        .version("1.0.0")
                        .description("Test Springdoc Swagger 3.0"));
    }

}
