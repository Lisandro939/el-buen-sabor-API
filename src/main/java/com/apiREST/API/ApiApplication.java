package com.apiREST.API;

import com.apiREST.API.Models.*;
import com.apiREST.API.Repositories.ClienteRepository;
import com.apiREST.API.Repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.sql.Time;

@SpringBootApplication
public class ApiApplication {

	@Autowired
	PedidoRepository pedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		System.out.println("API REST corriendo en http://localhost:8080/");
	}

}
