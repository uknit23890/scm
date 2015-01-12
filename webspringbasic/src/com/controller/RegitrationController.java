package com.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.User;
import com.dao.UserDao;

@Controller
@RequestMapping(value = "/")
public class RegitrationController {

	// injecting UserDao bean into this
	// class this is possible because we have declared it in
	// applicationContext.xml
	// as: <bean id="userDao" class="com.dao.UserDao" > </bean>
	@Autowired
	private UserDao userDao;

	@RequestMapping(method = RequestMethod.GET, value = "/signup")
	public String viewRegistration(Map<String, Object> model) {
		User userForm = new User();
		// To make gender default value as Male
		userForm.setGender("M");
		model.put("userForm", userForm);

		return "Signup";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/signup")
	public String signup(@ModelAttribute("userForm") User user,
			BindingResult result, Map<String, Object> model) {
		try {
			boolean isSaved = userDao.saveUser(user);
			if (isSaved) {
				model.put("msg", "User registered successfully");
			} else {
				model.put("msg", "User registration failed");
			}

		} catch (Exception e) {
			model.put("msg", "User registered failed:" + e.getMessage());
		}

		return "Signup";
	}

}
