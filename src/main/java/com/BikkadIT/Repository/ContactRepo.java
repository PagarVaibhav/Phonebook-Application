package com.BikkadIT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.Model.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer> {

	
}
