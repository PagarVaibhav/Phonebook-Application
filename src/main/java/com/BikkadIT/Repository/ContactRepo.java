package com.BikkadIT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.Model.Contact;
@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer> {

	
}
