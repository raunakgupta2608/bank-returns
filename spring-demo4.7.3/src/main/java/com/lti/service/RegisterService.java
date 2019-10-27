package com.lti.service;


import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lti.dao.RegisterDao;
import com.lti.entity.Otp;
import com.lti.entity.Registerib;

@Service
public class RegisterService 
{
	@Autowired
	private RegisterDao registerDao; 
	
	
	int accnofromfirstrequest;
	String loginpassfromsecondrequest;
	String transpassfromsecondrequest;
	int statuscodefromcustomerdetails;
	int statuscodefromregisterib;
	int otpfromthirdrequest;
	int otpgeneratedbyfunction;
	String ret="";
	public String fetchAccountNumberFromRegisterIBPage(int accno)
	{
		System.out.println("entering registerService controller fetchAccountNumberFromRegisterIBPage");
		accnofromfirstrequest = accno;
		
		statuscodefromregisterib = registerDao.checkAccountNumberFromRegisterIbTable( accnofromfirstrequest );
		statuscodefromcustomerdetails = registerDao.checkAccountNumberFromCustomerDetailsTable( accnofromfirstrequest );
		if ( statuscodefromregisterib == 1 && statuscodefromcustomerdetails == 1  )
		{
			ret = "setpassword.jsp";
		}
		else
		{
			ret = "error.jsp";
		}
		
		System.out.println( accnofromfirstrequest );
		System.out.println("leaving register service fetchAccountNumberFromRegisterIBPage");
		return ret;
	}
	/*public String checkAccountNumberFromCustomerDetailsTable(Registerib registerib) 
	{ 
		System.out.println("enterred register service checkAccountNumberFromCustomerDetailsTable");
		int flag = registerDao.checkAccountNumberFromCustomerDetailsTable(registerib); 
		String ret="";
		if(flag == 1)
			ret = "setpassword.jsp";
		else if(flag == -1)
			ret = "error.jsp";
		System.out.println("leaving register service checkAccountNumberFromCustomerDetailsTable");
		
		return ret;
	}*/
	
	////////////////////////////////////////////
	public void fetchPasswordFromSetPasswordPage( Registerib secondreqobj, String loginpass , String transpass )
	{
		System.out.println("entering register service fetchPasswordFromSetPasswordPage"); 
		
		loginpassfromsecondrequest = loginpass;
		System.out.println( loginpass );
		transpassfromsecondrequest = transpass;
		System.out.println( transpass );
		
		otpgeneratedbyfunction = Integer.parseInt(String.valueOf(generateOTP(4)));
	    System.out.println( otpgeneratedbyfunction );
	    
	    String email = registerDao.getEmail( secondreqobj );
	    
	    sendEmail( email, otpgeneratedbyfunction);
		/*saveDataFromFirstAndSecondRequest( secondreqobj );*/
		
		System.out.println("leaving register service fetchPasswordFromSetPasswordPage");
	}
	public void sendEmail( String email, int otpgeneratedbyfunction )
	{
		
		String emailid = email;
		int otpsentinmail = otpgeneratedbyfunction;
		System.out.println(" inside sendEmail method "+emailid);
		
		final String from = "sushantshastri24@gmail.com";
		String to = emailid;
		final String password = "shireesh";
		String host =  "smtp.gmail.com";
		String port = "587";
		

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.socketFactory.port", "465");
		
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", port);
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication (from, password);
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("HI");
			message.setText(" Your otp is : "+otpsentinmail);
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} 
		catch (MessagingException e) {  System.out.println(e); }
	}
	public String saveDataFromFirstAndSecondRequest( Registerib secondreqobj )
	{
		System.out.println("entering register service saveDataFromFirstAndSecondRequest"); 
		
		String ret="";
		
		/*secondreqobj.setAccno(accnofromfirstrequest);
		secondreqobj.setLoginpass(loginpassfromsecondrequest);
		secondreqobj.setTranspass(transpassfromsecondrequest);
		registerDao.saveDataFromFirstAndSecondRequest( secondreqobj );*/
		
		//int statuscodefromcustomerdetails = registerDao.checkAccountNumberFromCustomerDetailsTable( accnofromfirstrequest );
		//if( statuscodefromcustomerdetails == 1 ) 
		//{ 
		//	registerDao.saveDataFromFirstAndSecondRequest( secondreqobj ); 
		//} 
		//else if ( statuscodefromcustomerdetails == -1 ) 
		//{ ret = "error.jsp"; }
		 
		System.out.println("leaving register service saveDataFromFirstAndSecondRequest");
		return ret;
	}
	
	
	
	
	/*
	 * public String checkAccountNumberFromCustomerDetailsTable(Registerib registerib) {
	 * System.out.println("enterred register service checkAccountNumberFromCustomerDetailsTable"); int flag
	 * = getAccountNumber(registerib); String ret=""; if(flag == 1) ret =
	 * "setpassword.jsp"; else if(flag == -1) ret = "error.jsp";
	 * System.out.println("leaving register service checkAccountNumberFromCustomerDetailsTable");
	 * 
	 * return ret; } public int getAccountNumber(Registerib registerib) {
	 * System.out.println("enterred register service getAccountNumber"); int
	 * statuscodefromcustomerdetails = registerDao.getAccountNumber(registerib);
	 * System.out.println("leaving register service getAccountNumber"); return
	 * statuscodefromcustomerdetails; }
	 */
		
		public  char[] generateOTP(int length) 
		{
			 System.out.println("entering generateOTP");
		      String numbers = "1234567890";
		      Random random = new Random();
		      char[] otp = new char[length];
	
		      for(int i = 0; i< length ; i++) 
		      {
		         otp[i] = numbers.charAt(random.nextInt(numbers.length()));
		      }
		      System.out.println("leaving generateOTP");
		      return otp;
		}
		
		public String otpEnteredByUser( Registerib thirdreqobj, Otp otpobj,  int otp )
		{
			System.out.println("entering register service otpEnteredByUser"); 
			
			otpfromthirdrequest= otp;
			System.out.println(otpfromthirdrequest);
			
			thirdreqobj.setAccno(accnofromfirstrequest);
			thirdreqobj.setLoginpass(loginpassfromsecondrequest);
			thirdreqobj.setTranspass(transpassfromsecondrequest);
			
			if( otpfromthirdrequest == otpgeneratedbyfunction )
			{
				registerDao.saveDataFromFirstAndSecondAndThirdRequest( thirdreqobj );
				ret ="userlogin.jsp";
			}
			else
			{
				ret ="error.jsp";
			}
			
			
			return ret;
		}
	
	
	 
}
