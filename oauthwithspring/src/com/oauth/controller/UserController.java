package com.oauth.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oauth.service.User;


/**
 * @author www.sourcecodematrix.com
 * @Description  This is a controller class , here we have one rest api to get user.
 */
@Controller
public class UserController {

	@RequestMapping(value = "/rest/getuser", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody Object xmlSampleObjet() {
		User user = new User("sourcecodematrix@gmail.com", "admin", "Vinay", "Rawat", "7878666789");
		return user;
	}

}
