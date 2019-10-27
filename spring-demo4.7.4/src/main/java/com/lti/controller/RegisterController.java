package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.entity.Otp;
import com.lti.entity.Registerib;
import com.lti.service.RegisterService;

@Controller
public class RegisterController 
{
	@Autowired
	private RegisterService registerService;
	String ret = "";
	public String fetchAccountNumberFromRegisterIBPage(int accno)
	{
		System.out.println("entering register controller fetchAccountNumberFromRegisterIBPage");
		
		ret = registerService.fetchAccountNumberFromRegisterIBPage(accno);
		
		System.out.println("leaving register controller fetchAccountNumberFromRegisterIBPage");
		return ret;
	}
	
	/*public String checkAccountNumber(Registerib registerib) 
	{
		System.out.println("enterred register contoller");
		String ret = registerService.checkAccountNumber(registerib);
		System.out.println(ret);
		System.out.println("leaving register contoller");
		return ret;
	}*/
	 
	public void fetchPasswordFromSetPasswordPage( Registerib secondreqobj, String loginpass , String transpass )
	{
		System.out.println("entering register controller fetchPasswordFromSetPasswordPage");
		
		registerService.fetchPasswordFromSetPasswordPage(secondreqobj, loginpass, transpass);
		
		System.out.println("leaving register controller fetchPasswordFromSetPasswordPage");
	}
	
	public String otpEnteredByUser( Registerib thirdreqobj, Otp otpobj, int otp )
	{
		System.out.println("entering register controller otpEnteredByUser");
		
		ret = registerService.otpEnteredByUser( thirdreqobj, otpobj, otp );
		
		System.out.println("leaving register controller otpEnteredByUser");
		
		return ret;
	}
}
