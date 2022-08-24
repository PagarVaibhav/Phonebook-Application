package com.BikkadIT.ServiceImpl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Contact> getAll() {
		
		List<Contact> findAll = this.contactRepo.findAll();
		return findAll;
	}

	@Override
	public Contact getById(Integer cId) {
		
		Contact findById = contactRepo.findById(cId).get();
		
		return findById;
		
	}

	@Override
	public boolean updateContact(Contact contact) {
		
		Contact update = this.contactRepo.save(contact);
		
		if(update==null) {
			return false;
		}
		else {
		return true;
		}
	}

	@Override
	public boolean hardDeleteById(Integer cId) {
		
//		boolean existedData = this.contactRepo.existsById(cId);
//		
//		if(existedData) {
//			
//			this.contactRepo.deleteById(cId);
//			return true;
//		}
//		else {
//			return false;
//		}
		
		
		Optional<Contact> findById = this.contactRepo.findById(cId);
		
		if(findById.isPresent()) {
			this.contactRepo.deleteById(cId);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean softDeleteById(Integer cId) {
		
		Optional<Contact> contact = this.contactRepo.findById(cId);
		
		if(contact.isPresent()) {
			
			Contact contact2 = contact.get();
			contact2.setActiveSwitch('N');
			this.contactRepo.save(contact2);
			return true;
		}
		
		return false;
	}
}
