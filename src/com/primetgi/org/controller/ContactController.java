package com.primetgi.org.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primetgi.org.dao.ContactDAO;
import com.primetgi.org.model.Contact;

@Controller
@RequestMapping("/crud/contact")
public class ContactController {

	@Autowired
	private ContactDAO contactDAO;

	private static final Logger logger = Logger.getLogger(ContactController.class);

	@RequestMapping("/")
	public String showAllContacts(Model model) {
		logger.info("...In showAllContacts Method...");
		List<Contact> contacts = contactDAO.listAllContacts();
		model.addAttribute("contacts", contacts);
		return "contactsHome";
	}

	@RequestMapping(value = "/editContact")
	public String editContact(HttpServletRequest request, Model model) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactDAO.getContactDetails(contactId);
		model.addAttribute("contact", contact);
		return "contactForm";
	}

	@RequestMapping(value = "/saveContact")
	public String saveContact(@ModelAttribute Contact contact) {
		contactDAO.saveOrUpdateContact(contact);
		return "redirect:/crud/contact/";
	}

	@RequestMapping(value = "/newContact")
	public String newContact(Model model) {
		Contact newContact = new Contact();
		model.addAttribute("contact", newContact);
		return "contactForm";
	}

	@RequestMapping(value = "/deleteContact")
	public String deleteContact(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		contactDAO.deleteContact(id);
		return "redirect:/crud/contact/";
	}

	@RequestMapping("../../")
	public String mainPage() {
		return "home";
	}

}
