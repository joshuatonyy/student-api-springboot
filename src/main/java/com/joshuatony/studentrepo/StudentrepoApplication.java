package com.joshuatony.studentrepo;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentrepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentrepoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentService studentService) {
		return args -> {
			Address address = new Address("Indonesia", "Jawa Tengah", "Semarang", "Semarang Barat");
			Student studentSample = new Student("Test1", "test1@gmail.com", Gender.MALE, address, 2, 90.0, LocalDateTime.now());
			
			studentService.getStudentByEmail(studentSample.getEmail()).ifPresentOrElse(s -> {
				System.out.println("email " + studentSample.getEmail() + " sudah terdaftar");
			}, () -> {
				System.out.println("Inserting student " + studentSample);
				studentService.create(studentSample);
			});
		};
	}

}
