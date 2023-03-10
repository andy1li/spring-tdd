package com.hanselnpetal.springtdd.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.hanselnpetal.springtdd.domain.CustomerContact;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ContactsManagementControllerIntegrationTest {

	@Autowired
	ContactsManagementController contactsManagementController;

	@Test
	public void testAddContactHappyPath() {

		CustomerContact aContact = new CustomerContact();
		aContact.setFirstName("Jenny");
		aContact.setLastName("Johnson");

		String outcome = contactsManagementController.processAddContactSubmit(aContact);
		assertThat(outcome, is(equalTo("/addContactForm")));
	}

	@Test
	public void testAddContactFirstNameMissing() {

		CustomerContact aContact = new CustomerContact();
		String outcome = contactsManagementController.processAddContactSubmit(aContact);
		assertThat(outcome, is(equalTo("redirect:/showAddContact")));
	}
}
