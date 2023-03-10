package com.hanselnpetal.springtdd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hanselnpetal.springtdd.domain.ContactImportantOccasion;
import com.hanselnpetal.springtdd.domain.CustomerContact;
import com.hanselnpetal.springtdd.service.ContactsManagementService;

@Controller
public class ContactsManagementController {

	private final ContactsManagementService contactsManagementService;

	public ContactsManagementController(ContactsManagementService contactsManagementService) {
		this.contactsManagementService = contactsManagementService;
	}

	@PostMapping("/addContact")
	public String processAddContactSubmit(@RequestBody CustomerContact aContact) {
		CustomerContact newContact = contactsManagementService.add(aContact);
		if (newContact != null) {
			return "/addContactForm";
		}
		return "redirect:/showAddContact";
	}

	@GetMapping("/showAddContact")
	public String showAddContact() {
		// implement this
		return "/addContactForm";
	}

	public String processAddContactOccasionSubmit(
		@ModelAttribute CustomerContact aContact,
		@ModelAttribute ContactImportantOccasion anOccasion
	) {
		// implement this
		return "/addContactOccasionForm";
	}
}
