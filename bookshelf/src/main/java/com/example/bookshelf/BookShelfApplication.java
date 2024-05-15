package com.example.bookshelf;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
public class BookShelfApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookShelfApplication.class, args);
	}

}
