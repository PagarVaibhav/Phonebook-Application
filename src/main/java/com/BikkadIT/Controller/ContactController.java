package com.BikkadIT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.Model.Contact;
import com.BikkadIT.Service.ContactService;

@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@PostMapping(value="/saveContact" , consumes = "application/json")
	public ResponseEntity<String> saveContactDetails(@RequestBody Contact contact){
		
		boolean savedContact = this.contactService.saveContact(contact);
		
		if(savedContact == true) {
			String msg="Saved Contact Successfully";
			return new ResponseEntity<>(msg , HttpStatus.CREATED);
		}else {
			
			String msg1="Contact Not Saved Please Enter Valid Details";
			
			return new ResponseEntity<String>(msg1 , HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/getAll")
	public ResponseEntity<List<Contact>> getAllContact(){
		
		List<Contact> allContacts = this.contactService.getAll();
		if(allContacts!=null) {
			return new ResponseEntity<List<Contact>>(allContacts , HttpStatus.OK);
		}else {
			return new ResponseEntity("Data Not Fount" , HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping(value = "/getContactById/{cId}")
	public ResponseEntity<Contact> getContactById(@PathVariable Integer cId) {
		
		Contact contactById = this.contactService.getById(cId);
		
		return new ResponseEntity<Contact>(contactById, HttpStatus.OK);
		}
}
