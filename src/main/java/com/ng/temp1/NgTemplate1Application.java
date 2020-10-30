package com.ng.temp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:env.properties")
public class NgTemplate1Application {

	public static void main(String[] args) {
		SpringApplication.run(NgTemplate1Application.class, args);
	}

}
