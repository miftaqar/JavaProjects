package com.primetgi.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primetgi.org.dao.UserDAO;
import com.primetgi.org.dao.UserDAOImpl;
import com.primetgi.org.model.User;

@Controller
@RequestMapping(value = "/usersList")
public class UsersController {

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "/list")
	public String showUserPage(Model model) {
		List<User> listUsers = userDAO.list();
		model.addAttribute("listOfUsers", listUsers);
		
		System.out.println("Test1");
		return "usersListPage";
	}
	
}
