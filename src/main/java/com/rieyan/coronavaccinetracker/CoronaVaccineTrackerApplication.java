package com.rieyan.coronavaccinetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronaVaccineTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaVaccineTrackerApplication.class, args);
	}

}
