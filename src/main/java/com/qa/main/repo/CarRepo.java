package com.qa.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.qa.main.domain.Cars;

@Repository
public interface CarRepo extends JpaRepository<Cars,Long> {

	
	// auto generates a SQL statement
	List <Cars> findByCarMake(String carMake);
	
	
}
