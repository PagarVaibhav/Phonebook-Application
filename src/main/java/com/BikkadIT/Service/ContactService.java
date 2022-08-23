package com.BikkadIT.Service;

import java.util.List;

import com.BikkadIT.Model.Contact;

public interface ContactService {

	public boolean saveContact(Contact contact);
	
	public List<Contact> getAll();
}
