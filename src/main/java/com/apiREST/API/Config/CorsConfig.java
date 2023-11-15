package com.apiREST.API.Config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer {

    public void addCorsMapping(CorsRegistry registry){
            registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("DELETE", "PUT", "GET", "POST", "OPTIONS")
            .allowCredentials(true)
            .allowedHeaders("*");


    }

}
