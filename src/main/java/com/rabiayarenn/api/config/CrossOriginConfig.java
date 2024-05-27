package com.rabiayarenn.api.config;

/*
buna bir request attığımda api cevap verebilmesi için bu classın olması gerekir
Temiz bir mimari de ilerleyebilmek için
* */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossOriginConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")//ne geliyorsa kabul et
                        .allowedMethods("HEAD","GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH");
            }
        };
    }
}
