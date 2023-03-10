package com.hanselnpetal.springtdd.service;

import org.springframework.stereotype.Service;

import com.hanselnpetal.springtdd.data.repos.CustomerContactRepository;
import com.hanselnpetal.springtdd.domain.CustomerContact;

@Service
public class ContactsManagementService {

	private final CustomerContactRepository customerContactRepository;

	public ContactsManagementService(CustomerContactRepository customerContactRepository) {
		this.customerContactRepository = customerContactRepository;
	}

	public CustomerContact add(CustomerContact aContact) {

		CustomerContact newContact = null;

		if (aContact.getFirstName() != null) {
			newContact = customerContactRepository.save(aContact);
		}
		
		return newContact;	
	}
	
	/*
	public CustomerContact addContactOccasion(CustomerContact aContact, ContactImportantOccasion anOccasion) {
		CustomerContact newContact = null;
		
		return newContact;	
	}
	*/
}
