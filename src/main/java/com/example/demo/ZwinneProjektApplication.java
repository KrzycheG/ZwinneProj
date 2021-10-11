package com.example.demo;
import com.example.demo.book.book;
import org.apache.el.parser.AstIdentifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class ZwinneProjektApplication {

	public static void main(String[] args) {

		SpringApplication.run(ZwinneProjektApplication.class, args);

	}
	@GetMapping

	public List<book> books(){
		return List.of(
			new book(
				"Potop",
				25,5
			)
		);
	}



}
