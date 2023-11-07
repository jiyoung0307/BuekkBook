package com.bukkeubook.book.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.bukkeubook.book"})
@EnableJpaRepositories(basePackages = "com.bukkeubook.book")
public class JPAConfiguration {

}
