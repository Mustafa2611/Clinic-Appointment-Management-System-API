package com.example.Eyada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ClinicAppointmentSystem {

	public static void main(String[] args) {

		SpringApplication.run(ClinicAppointmentSystem.class, args);
	}

}
