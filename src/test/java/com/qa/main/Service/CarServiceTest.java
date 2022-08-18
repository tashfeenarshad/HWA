package com.qa.main.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.main.domain.Cars;
import com.qa.main.repo.CarRepo;
import com.qa.main.services.CarService;

@SpringBootTest
public class CarServiceTest {

		@Autowired
		private CarService service;
		
		@MockBean
		private CarRepo repo;
		
		@Test
		public void testCreate() {
			Cars entry = new Cars ("nissan", 100);
			
			Cars result = new Cars (2L,"nissan",100);
			 Mockito.when(repo.saveAndFlush(entry)).thenReturn(result);

		        assertEquals(result, service.create(entry));

		}
		
		@Test
		public void testGetAll() {
			List<Cars> result = new ArrayList<>();
			result.add(new Cars(1L,"porsche", 5443));
			Mockito.when(repo.findAll()).thenReturn(result);

	        assertEquals(result, service.getAll());
		}
		@Test
		public void testUpdate() {
			Cars result = new Cars (1L,"nissan",100);
			Optional<Cars> resultOP= Optional.ofNullable(result);
			 Mockito.when(repo.findById(1L)).thenReturn(resultOP);

		        Mockito.when(repo.saveAndFlush(result)).thenReturn(result);

		        assertEquals(result, service.update(1L, result));

			
		}
		
		 @Test
		    public void testDelete() {
		        Mockito.when(repo.existsById(1L)).thenReturn(false);

		        assertEquals(true, service.delete(1L));
		    }

		
		
}
