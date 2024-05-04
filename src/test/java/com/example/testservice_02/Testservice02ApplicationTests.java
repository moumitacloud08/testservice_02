package com.example.testservice_02;

import com.example.testservice_02.controller.CityController;
import com.example.testservice_02.dao.CityDao;
import com.example.testservice_02.entity.City;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(CityController.class)
class Testservice02ApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CityDao cityDao;

	@Test
	public void shouldSaveCities() throws Exception{
		mvc.perform(put("/cities").content("{ \"name\":\"Los Angeles\"}").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

		mvc.perform(
				put("/cities")
						.content("{ \"name\": \"New York\" }")
						.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk());


		verify(cityDao).save(City.builder().name("Los Angeles").build());
		verify(cityDao).save(City.builder().name("New York").build());

	}




}
