package com.rajoria.jpa;

import com.rajoria.jpa.model.Author;
import com.rajoria.jpa.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Hello, this is executed on application startup!");
			initializeDatabase();
		};
	}


	@Autowired
	AuthorRepository authorRepository;

	private void initializeDatabase() {
		// Logic to initialize the database

		var author = Author.builder()
				.firstName("Ashish")
				.lastName("Sharma")
				.age(30)
				.email("ashish13102376@gmail.com")
				.build();

		authorRepository.save(author);
		System.out.println("Database initialized.");
	}

}
