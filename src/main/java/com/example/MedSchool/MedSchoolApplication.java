package com.example.MedSchool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.example.MedSchool"})
public class MedSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedSchoolApplication.class, args);
	}

}
