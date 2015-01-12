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

@Controller
@RequestMapping(value = "/")
public class RegitrationController {
	@Autowired
	private HttpSession session=null;
	@RequestMapping(method = RequestMethod.GET,value = "/viewSignup")
	public String viewRegistration(Map<String, Object> model) {
		User userForm = new User();
		model.put("userForm", userForm);
		return "Signup";
	}
	@RequestMapping(method = RequestMethod.POST, value = "/signup")
	public String  signup(@ModelAttribute("userForm") User user, BindingResult result,
			Map<String, Object> model) throws Exception {
		System.out.println(user.getEmail());
		session.setAttribute("msg", "Below is details of registration");
		return "Signup";
	}
}
