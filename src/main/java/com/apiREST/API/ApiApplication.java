package com.apiREST.API;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "El buen sabor API", version = "1.0", description = "Documentación API El buen sabor"))
public class ApiApplication {

	@Bean
	public WebMvcConfigurer corsMappingConfigurer()
	{
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("*")
						.allowedHeaders("*");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

		System.out.println("API REST corriendo");
	}
}
