package com.imgur.assignment.imgurapiassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ImgurApiAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImgurApiAssignmentApplication.class, args);
	}

}
