package com.bukkeubook.book.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bukkeubook.book"})
public class BukkeubookFinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BukkeubookFinalProjectApplication.class, args);
	}

}
