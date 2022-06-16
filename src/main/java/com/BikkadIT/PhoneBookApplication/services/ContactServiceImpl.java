package com.BikkadIT.PhoneBookApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.PhoneBookApplication.model.Contact;
import com.BikkadIT.PhoneBookApplication.repository.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService {
	
    @Autowired
	private ContactRepository contactRepository;
	
	@Override
	public boolean SaveContact(Contact contact) {
		
		Contact save=contactRepository.save( contact);
		  
		 if (save!=null) {
			return true ;
					
		} else {
			
			return false;
		}
	}

}
