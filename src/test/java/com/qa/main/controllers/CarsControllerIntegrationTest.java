package com.qa.main.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.domain.Cars;

import java.util.List;
import java.util.ArrayList;


@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts= {"classpath:testschema.sql","classpath:testdata.sql"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")//switching to h2 for integration testing
public class CarsControllerIntegrationTest {

	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;//used to convert objects into JSON
	
	@Test
	public void createTest() throws Exception {
		//create an object for posting
		Cars entry = new Cars("Merc",750);
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		//object for checking the result
		Cars result = new Cars(2L,"Merc",750);
		String resultAsJSON = mapper.writeValueAsString(result);
		
		
		mvc.perform(post("/cars/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));
		
	}
	@Test
	public void readAllTest() throws Exception {
		List <Cars> result = new ArrayList<>();
		result.add(new Cars(1L,"Nissan",1000));
		
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/cars/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));		
	}
	@Test
	public void readbyID() throws Exception {
	
		Cars result= new Cars(1L,"Nissan",1000);
		
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/cars/getByID/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	/* 
	@Test
	public void updateTest() throws Exception {
		
	}
	*/
	@Test
	public void deleteTest() throws Exception {
		mvc.perform(delete("/cars/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
	
	
	
	
	
	
}
