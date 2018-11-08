package com.primetgi.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.primetgi.contact.dao.ContactDAO;

@Controller
public class ContactController {

	@Autowired
	private ContactDAO contactDAO;
	
	
}
