package com.BikkadIT.PhoneBookApplication.services;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Contact> getAllContact() {
     List<Contact> contacts = contactRepository.findAll();
		
		if (contacts !=null ) {
			return contacts;
		}else {
			return null;
		}
		
	}

	@Override
	public Contact getContactById(Integer cid) {
      Optional<Contact> findById=contactRepository.findById(cid);
		if (findById.isPresent()) {
			Contact contact = findById.get();
			return contact;
		}
		return null;
	}

	@Override
	public boolean UpdateContact(Contact contact) {
       Contact save=contactRepository.save(contact);
       if (save != null) {
		return true;
	} else {
        return false;
	}
	}

	@Override
	public boolean deleteById(Integer cid) {
         Optional<Contact> findById=contactRepository.findById(cid);
         
         if (findById.isPresent()) {
			
        	 contactRepository.deleteById(cid);
        	 return true;
		} else {
			return false;
		}
		
	}

}
