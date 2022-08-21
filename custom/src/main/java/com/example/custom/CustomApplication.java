package com.example.custom;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.jdbc.core.JdbcTemplate;



@SpringBootApplication
public class CustomApplication  extends SpringBootServletInitializer{
	@Autowired
	//private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(CustomApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CustomApplication.class);
	}

	

}
