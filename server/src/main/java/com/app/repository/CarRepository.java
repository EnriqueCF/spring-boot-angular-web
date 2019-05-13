package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.data.Car;

@RepositoryRestResource
//@CrossOrigin(origins = "http://localhost:4200")
public interface CarRepository extends JpaRepository<Car, Long> {
	
}
