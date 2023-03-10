package com.hanselnpetal.springtdd.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.hanselnpetal.springtdd.domain.CustomerContact;
import com.hanselnpetal.springtdd.service.ContactsManagementService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ContactsManagementController.class)
public class ContactsManagementControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ContactsManagementService contactsManagementService;

	@InjectMocks
	private ContactsManagementController contactsManagementController;

	ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void testAddContactHappyPath() throws Exception {
		// setup mock Contact returned the mock service component
		CustomerContact mockCustomerContact = new CustomerContact();
		mockCustomerContact.setFirstName("Fred");

		when(contactsManagementService.add(any(CustomerContact.class)))
			.thenReturn(mockCustomerContact);

		// simulate the form bean that would POST from the web page
		CustomerContact aContact = new CustomerContact();
		aContact.setFirstName("Fred");
		aContact.setEmail("fred@fred.com");

		mockMvc
			.perform(post("/addContact")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(aContact)))
			.andExpect(status().isOk())
			.andReturn();
	}

	@Test
	public void testAddContactBizServiceRuleNotSatisfied() throws Exception {

		// setup a mock response of NULL object returned from the mock service component
		when(contactsManagementService.add(any(CustomerContact.class)))
			.thenReturn(null);

		// simulate the form bean that would POST from the web page
		CustomerContact aContact = new CustomerContact();
		aContact.setLastName("Johnson");

		// simulate the form submit (POST)
		mockMvc
			.perform(post("/addContact")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(aContact)))
			.andExpect(status().is(302))
			.andReturn();
	}

	@Disabled
	@Test
	public void testAddContactOccasionHappyPath() throws Exception {
		// implement this
	}
}
