package com.qa.main.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.main.carExceptions.CarExceptions;
import com.qa.main.domain.Cars;
import com.qa.main.repo.CarRepo;
@Service
public class CarService {

	private CarRepo repo;
	public CarService(CarRepo repo){
		this.repo = repo;
	}
	
	

	public Cars create( Cars Newcars) {
		return repo.saveAndFlush(Newcars);
		
	}
	
	//get requests-read
	
	public List<Cars> getByCarMake (String carMake){
		return repo.findByCarMake(carMake);
	}
	
	public List<Cars> getAll(){
		return repo.findAll();
		
	}
	public Cars getByID(long id) {
		return repo.findById(id).orElseThrow(CarExceptions::new);
	}
	
	
	
	public Cars update( long id,  Cars Newcars) {
		Cars exisiting = repo.findById(id).get();
		exisiting.setCarMake(Newcars.getCarMake());
		exisiting.setBhp(Newcars.getBhp());
		return repo.saveAndFlush(exisiting);
		
	}
	
	//delete requests-delete
	
	public boolean delete(long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
	
}




