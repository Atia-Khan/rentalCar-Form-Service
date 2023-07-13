package com.atia.roadrunner.rentalform;


import java.time.LocalDateTime;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.atia.roadrunner.rentalform.Controller.FormController;
import com.atia.roadrunner.rentalform.Model.Form;
import com.atia.roadrunner.rentalform.Repository.IFormRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
class FormControllerTests {

	private MockMvc mvc;
	@Mock
	private IFormRepository formRepo;

	@InjectMocks
	private FormController formController;

	private JacksonTester<Form> jsonForm;

	private JacksonTester<Collection<Form>> jsonForms;

	@BeforeEach
	public void setUp() {
		JacksonTester.initFields(this, new ObjectMapper());
		mvc = MockMvcBuilders.standaloneSetup(formController).build();
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void canAddANewForm() throws Exception {
		Form form = new Form(3L, "atia", "43AGBG", "3213464",  null, 5L, null, "1523544", 435435435.0, 150324.0);
       when(formRepo.save(form)).thenReturn((form));
		mvc.perform(post("/forms/post")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonForm.write(form).getJson()))
				.andExpect(status().isOk());

	}

	@Test
	public void canGetAllCars() throws Exception {
		Form form1 = new Form(1L, "atia", "43AGBG", "3213464",  null, 5L, null, "1523544", 435435435.0, 150324.0);

       Form form2 = new Form(2L, "atia", "43AGBG", "3213464",  null, 5L,null, "1523544", 435435435.0, 150324.0);
		List<Form> formList = new ArrayList<>();
		formList.add(form1);
		formList.add(form2);
		when(formRepo.findAll()).thenReturn(formList);
		mvc.perform(get("/forms/get")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(jsonForms.write(formList).getJson()));
	}

	@Test
	public void canGetAForm() throws Exception {
		
        Form form1 = new Form(1L, "atia", "43AGBG", "3213464",  null, 5L,null, "1523544", 435435435.0, 150324.0);
		when(formRepo.findById(1L)).thenReturn(Optional.of(form1));
		mvc.perform(MockMvcRequestBuilders.get("/forms/get/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(jsonForm.write(form1).getJson()));
    }

}