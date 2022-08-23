package com.BikkadIT.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.Model.Contact;
import com.BikkadIT.Repository.ContactRepo;
import com.BikkadIT.Service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepo contactRepo;

	@Override
	public boolean saveContact(Contact contact) {
		
		Contact saveContact = this.contactRepo.save(contact);
		
		if(saveContact != null) {
			
			return true;
		}
		else {
		
		return false;
		}
	}
}
