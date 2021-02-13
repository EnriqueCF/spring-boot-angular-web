package com.app.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.data.Car;
import com.app.repository.CarRepository;

@RestController
public class CoolCarController {
	private static final Logger log = LoggerFactory.getLogger(CoolCarController.class);
	
	private CarRepository carRepository;

	public CoolCarController(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	@GetMapping("/cool-cars")
	//@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Car> coolCars () {
		log.info("GetMapping: /cool-cars");
		return carRepository.findAll().stream().filter(this::isCool).collect(Collectors.toList());
	}
	
	private boolean isCool (Car car) {
		return  !car.getName().equalsIgnoreCase("AMC Gremlin") &&
                !car.getName().equalsIgnoreCase("Triumph Stag") &&
                !car.getName().equalsIgnoreCase("Ford Pinto") &&
                !car.getName().equalsIgnoreCase("Yugo GV");
	}
}
