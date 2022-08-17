package com.qa.main.controllers;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.domain.Cars;
import com.qa.main.services.CarService;



@RestController
@CrossOrigin




@RequestMapping("/cars")
public class CarController {

	private CarService service;
	
	
	public CarController(CarService service) {
		super();
		this.service = service;
	}
	
	
//put requests-create
	@PostMapping("/create")
	public ResponseEntity<Cars> create(@RequestBody Cars Newcars) {
		return new ResponseEntity<Cars>(service.create(Newcars),HttpStatus.CREATED);
	
	}
	

	//get requests-read
	@GetMapping("/getAll")
	public List<Cars> getAll(){
		return service.getAll();
	}
	@GetMapping("/getByID/{id}")
	public Cars getByID(@PathVariable long id) {
		 return service.getByID(id);
	}
	
	@GetMapping("/getbyCarMake/{carMake}")
	public List<Cars> getbyCarMake(@PathVariable String carMake){
		return service.getByCarMake(carMake);
	}
	
	//put requests-update
	@PutMapping("/update/{id}")
	
	public Cars update(@PathVariable long id, @RequestBody Cars Newcars) {
		return service.update(id, Newcars);
	}
	
	//delete requests-delete
	@DeleteMapping ("/delete/{id}")
	public ResponseEntity <Boolean> delete(@PathVariable long id) {
		return new ResponseEntity<Boolean>(service.delete(id),HttpStatus.NO_CONTENT);
		
		// add response entity 
	}
	
	
}
