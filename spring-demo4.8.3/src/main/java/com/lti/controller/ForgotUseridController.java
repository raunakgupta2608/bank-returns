package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.service.ForgotUseridService;
@Controller
public class ForgotUseridController {
	String ret="";
	@Autowired
	private ForgotUseridService forgotUseridService;
	public String chkAccountNumberForUserid(int accno)
	{
		System.out.println("entering forgotuserid controller checkaccnoforgotuser");
		ret=forgotUseridService.chkAccountNumberForUserid(accno);
		return ret;
	}
	public String chkOtpForUserid(int otp)
	{
		ret=forgotUseridService.chkOtpForUserid(otp);
		return ret;
	}
	}

