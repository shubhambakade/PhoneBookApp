package com.BikkadIT.PhoneBookApplication.services;

import java.util.List;

import com.BikkadIT.PhoneBookApplication.model.Contact;

public interface ContactService {

  boolean SaveContact(Contact contact);
  
  List<Contact> getAllContact();
  
}
