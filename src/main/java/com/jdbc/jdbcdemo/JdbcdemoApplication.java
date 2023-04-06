package com.jdbc.jdbcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class JdbcdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcdemoApplication.class, args);
	}

}
