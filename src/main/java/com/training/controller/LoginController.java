package com.training.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.model.Login;
import com.training.model.User;

@Controller
public class LoginController {

	// login

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("login", new User());
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Login login) {
		
		
		ModelAndView modelAndView = null;
		User user = validateUser(login);
		if (user != null) {
			modelAndView = new ModelAndView("welcome");
			modelAndView.addObject("firstName", user.getfName());
		} else {
			modelAndView = new ModelAndView("login");
			modelAndView.addObject("message", "Invalid User Name or Password");
		}
		return modelAndView;
	}

	private User validateUser(Login login) {
		List<User> users = new ArrayList<User>();
		users.add(new User("admin", "123", "Admin", "User", "user@gmail.com", "322323", "NOIDA"));
		users.add(new User("user1", "123", "Admin1", "User", "user@gmail.com", "322323", "NOIDA"));
		users.add(new User("user2", "123", "Admin2", "User", "user@gmail.com", "322323", "NOIDA"));
		users.add(new User("user3", "123", "Admin3", "User", "user@gmail.com", "322323", "NOIDA"));

		for (User user : users) {
			if (user.getUserName().equals(login.getUserName()) && user.getPassword().equals(login.getPassword())) {
				return user;
			}
		}
		return null;
	}

	// signup
}
