package com.BikkadIT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.Model.Contact;
import com.BikkadIT.Service.ContactService;

@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;
	
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
}
