package com.BikkadIT.PhoneBookApplication.controller;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.PhoneBookApplication.model.Contact;
//import com.BikkadIT.PhoneBookApplication.props.AppConstants;
//import com.BikkadIT.PhoneBookApplication.props.AppProps;
import com.BikkadIT.PhoneBookApplication.services.ContactServiceImpl;

@RestController
public class ContactController {

	@Autowired
	private ContactServiceImpl contactServiceImpl;
	
//	@Autowired
//	private AppProps appProps;
	
	@PostMapping(value = "/savecontact",consumes = {"application/json"})
//	public ResponseEntity<String> SaveContact(@RequestBody Contact contact){
//		
////		Map<String, String> massages =appProps.getMessages();
////		System.out.println(massages);
//		
//	  boolean	save=contactServiceImpl.SaveContact(contact);
//		
////	  if (save==true) {
////		String msg =massages.get(AppConstants.SAVE_SUCCESS);
////		return  new ResponseEntity<String>(msg,HttpStatus.CREATED);
////		
////	  } else {
////         String msg =massages.get(AppConstants.SAVE_FAIL);
////		return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
////	    }
//   }
	
	@GetMapping(value="/getAllContact",produces = "application/json")
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
	@GetMapping("/edit/{cid}")	
	public ResponseEntity<Contact> getContactById(@PathVariable Integer cid){
		
		Contact contact=contactServiceImpl.getContactById(cid);
		if (contact !=null) {
			return new ResponseEntity<Contact>(contact,HttpStatus.OK);
		} else {
			String s ="Record Not Found";
			return new ResponseEntity(s,HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/updateContact")
	public ResponseEntity<String> updateContact(Contact contact){
		boolean contact1=contactServiceImpl.UpdateContact(contact);
		if (contact1 == true) {
			return new ResponseEntity<String>("Contact Updated Successfully",HttpStatus.OK);
		} else {
			  String msg ="Contact not updated";
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/deleteContactById/{cid}")
	public String deleteContactById(@PathVariable("cid") Integer cid) {
	
		boolean deleteById=contactServiceImpl.deleteById(cid);
		if (deleteById == true) {
			
			return "Record deleted Successfully";
			
		} else {
			return "Record not deleted";
		}
		
		
	}
}
