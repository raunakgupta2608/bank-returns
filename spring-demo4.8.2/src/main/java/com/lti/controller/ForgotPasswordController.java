package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.entity.Otp;
import com.lti.entity.Registerib;
import com.lti.service.ForgotPasswordService;

@Controller
public class ForgotPasswordController {

	@Autowired
	ForgotPasswordService forgotpasswordService;
	
	String ret="";
	public String checkUserId(int userid)
	{
		System.out.println("Inside forgot password Controller.........");
		ret=forgotpasswordService.checkUserId(userid);
		return ret;
	}
public String checkOtp(int otp)
{
	System.out.println("Inside Check Otp forgot pass controller.................");
	ret=forgotpasswordService.checkOtp(otp);
	return ret;
}
public String setLoginPasswordByUser(String lpass,int globaluserid)
{
	System.out.println("Inside Set Password forgot pass controller.................");
	ret=forgotpasswordService.setLoginPasswordByUser(lpass,globaluserid);
	return ret;
}

}
