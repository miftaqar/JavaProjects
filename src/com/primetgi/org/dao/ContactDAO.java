package com.primetgi.org.dao;

import java.util.List;

import com.primetgi.org.model.Contact;

public interface ContactDAO {

	public void saveOrUpdateContact(Contact contact);
	
	public void deleteContact(int contactId);
	
	public Contact getContactDetails(int contactId);
	
	public List<Contact> listAllContacts();
	
}
