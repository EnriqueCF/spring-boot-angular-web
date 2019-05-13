package com.app;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.data.Car;
import com.app.repository.CarRepository;

@SpringBootApplication
public class SpringBootAngularWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularWebApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init (CarRepository repository) {
		return args -> { Stream.of("Ferrari", "Jaguar", "Lamborghini", "Bugatti", "AMC Gremlin", "Triumph Stag", "Ford pinto", "Yugo GV")
			.forEach(name -> {
				Car car = new Car();
				car.setName(name);
				repository.save(car);
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}
