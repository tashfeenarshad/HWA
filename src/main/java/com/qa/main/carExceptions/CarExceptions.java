package com.qa.main.carExceptions;

	
	import java.util.NoSuchElementException;
	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.ResponseStatus;
	
	
	@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT, reason = "car not found with that ID")
	public class CarExceptions extends NoSuchElementException {

		
		
	}
	
	

