package com.BikkadIT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping(value = "/UpdateContact")
	public ResponseEntity<String> UpdateContact(@RequestBody Contact contact) {

		boolean updatedContact = this.contactService.updateContact(contact);

		if (updatedContact == true) {
			String msg = "Contact Updated Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} 
		else {
			String msg = "Contact  not updated Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
}
	
	@DeleteMapping(value="/delete/{cId}")
	public ResponseEntity<String> hardDeletion(@PathVariable Integer cId){
		
		boolean hardDeleteById = this.contactService.hardDeleteById(cId);
		
		if(hardDeleteById) {
			String msg="Contact Deleted Successfully";
			return new ResponseEntity<String>(msg , HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Given Id Does Not Exist" , HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value="/softDelete/{cId}")
	public ResponseEntity<String> softDeletion(@PathVariable Integer cId){
		
		boolean softDeleteById = this.contactService.softDeleteById(cId);
		
		if(softDeleteById) {
			String msg="Contact Deleted Successfully";
			return new ResponseEntity<String>(msg , HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Given Id Does Not Exist" , HttpStatus.BAD_REQUEST);
		}
	}
}