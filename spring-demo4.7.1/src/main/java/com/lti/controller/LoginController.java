package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.lti.service.LoginService;

@Controller
public class LoginController
{
	@Autowired
	private LoginService loginService;
	String ret = "";
	
	public String loginDetailsEnteredByUser(int userid,String password)
	{
		System.out.println("Inside Login Controller.........");
			ret=loginService.loginDetailsEnteredByUser(userid, password);
			return ret;
	}

}
