package com.hanselnpetal.springtdd.service;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.hanselnpetal.springtdd.data.repos.CustomerContactRepository;
import com.hanselnpetal.springtdd.domain.CustomerContact;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ContactsManagementServiceUnitTest {

	@Mock
	private CustomerContactRepository customerContactRepository;

	@InjectMocks
	private ContactsManagementService contactsManagementService;

	@Test
	public void testAddContactHappyPath() {

		// Create a contact
		CustomerContact aMockContact = new CustomerContact();
		aMockContact.setFirstName("Jenny");
		aMockContact.setLastName("Johnson");

		when(customerContactRepository.save(any(CustomerContact.class))).thenReturn(aMockContact);

		// Save the contact
		CustomerContact anotherMockContact = new CustomerContact();
		anotherMockContact.setFirstName("Mock");
		CustomerContact newContact = contactsManagementService.add(anotherMockContact);
		assertEquals("Jenny", newContact.getFirstName());
	}
}
