package com.qa.main.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.domain.Cars;
import com.qa.main.services.CarService;

@WebMvcTest
public class CarsControllerUnitTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private CarService service;
	
	@Test
	void createTest() throws Exception{
		{
			//create an object for posting
			Cars entry = new Cars("Merc",750);
			String entryAsJSON = mapper.writeValueAsString(entry);
			
			//object for checking the result
			Cars result = new Cars(2L,"Merc",750);
			String resultAsJSON = mapper.writeValueAsString(result);
			
			
			Mockito.when(service.create(entry)).thenReturn(result);
			
			mvc.perform(post("/cars/create")
					.contentType(MediaType.APPLICATION_JSON)
					.content(entryAsJSON))
					.andExpect(content().json(resultAsJSON));
			
		}
	}

	
	
	
}
