package com.phonebook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.exception.ResourceNotFoundException;
import com.phonebook.model.Contact;
import com.phonebook.repository.ContactRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ContatController {

	@Autowired
	private ContactRepository contactRepository;
	
	
	// get all contacts
	@GetMapping("/contacts")
	public List<Contact> getAllContacs() {
		return contactRepository.findAll();	
	}
	
	
	// create contact
	@PostMapping("/contact")
	public Contact saveContact(@RequestBody Contact contact){
		Long contactId = contact.getContactId();

		if(contactId != null)
		{
			contact.setContactId(contact.getContactId());
		}
		
		return contactRepository.save(contact);
	}
	
	
	// get contact by id
	@GetMapping("/contact/{id}")
	public ResponseEntity<Contact> getContactById(@PathVariable long id) {
		Contact contact = contactRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Contact does not exist with ID : "+id));
		return ResponseEntity.ok(contact);
	}
	
	
	// delete contact 
	@DeleteMapping("/contact/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteContact(@PathVariable Long id){
		Contact contact = contactRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Contact does not exist with ID : "+id));
		contactRepository.delete(contact);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
}
