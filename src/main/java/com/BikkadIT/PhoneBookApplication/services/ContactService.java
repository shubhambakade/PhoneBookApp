package com.BikkadIT.PhoneBookApplication.services;

import java.util.List;

import com.BikkadIT.PhoneBookApplication.model.Contact;

public interface ContactService {

  boolean SaveContact(Contact contact);
  
  List<Contact> getAllContact();
  
  Contact getContactById(Integer cid);
  
  public boolean UpdateContact(Contact contact);
  
  public boolean deleteById(Integer cid);
  
}
