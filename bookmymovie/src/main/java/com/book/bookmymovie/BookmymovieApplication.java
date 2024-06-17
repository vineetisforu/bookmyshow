package com.book.bookmymovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
@EnableJpaRepositories(basePackages="com.book")
public class BookmymovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmymovieApplication.class, args);
	}

}
