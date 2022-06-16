package com.BikkadIT.PhoneBookApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.PhoneBookApplication.model.Contact;
import com.BikkadIT.PhoneBookApplication.services.ContactServiceImpl;

@RestController
public class ContactController {

	@Autowired
	private ContactServiceImpl contactServiceImpl;
	
	@PostMapping(value = "/savecontact",consumes = {"application/json"})
	public ResponseEntity<String> SaveContact(@RequestBody Contact contact){
		
	boolean	save=contactServiceImpl.SaveContact(contact);
		
	if (save==true) {
		String msg ="Contact save Successfully";
		
		return  new ResponseEntity<String>(msg,HttpStatus.CREATED);
	} else {
         String msg ="Contact Not Saved Successfully";
		return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
	    }
   }
	
	@GetMapping(value="/getAllContact",produces = "APPLICATION/JSON")
	public ResponseEntity<List<Contact>> getAllContact(){
	
		List<Contact> list = contactServiceImpl.getAllContact();
		
		if(list !=null) {
			return new ResponseEntity<List<Contact>> (list,HttpStatus.OK);
		}else
		{
			String msg="Data Not found";
		return new ResponseEntity(msg,HttpStatus.BAD_REQUEST);
		}
	}
		
}
