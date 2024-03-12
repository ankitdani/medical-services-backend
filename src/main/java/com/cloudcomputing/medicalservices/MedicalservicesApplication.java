package com.cloudcomputing.medicalservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MedicalservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalservicesApplication.class, args);
	}

}
