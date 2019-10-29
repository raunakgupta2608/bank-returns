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

import com.lti.dao.ForgotPasswordDao;
import com.lti.entity.Otp;
import com.lti.entity.Registerib;

@Service
public class ForgotPasswordService {

@Autowired
ForgotPasswordDao forgotpasswordDao;
	
	String ret="";
	int flag=0;
	String email="";
	int otpgeneratedbyfunction;
	int otpfromuser;
	public String checkUserId(int userid)
	{
		System.out.println("Inside ForgotPassword Service.........");
		flag=forgotpasswordDao.checkUserId(userid);
		if (flag==1)
		{
			
			getEmail();
			ret="enterotppass.jsp";
		}
		else 
			ret="errfrgtpass.jsp"; //Invalid UserId
		return ret;
	}
	
	
	public void getEmail()
	{
		email=forgotpasswordDao.getEmailId();
		System.out.println(email);
		otpgeneratedbyfunction = Integer.parseInt(String.valueOf(generateOTP(4)));
	    System.out.println( otpgeneratedbyfunction );
		sendEmail(email,otpgeneratedbyfunction);
	}
	
	public void sendEmail(String email,int otpgeneratedbyfunction)
	{
		String emailid = email;
		int optsentinmail=otpgeneratedbyfunction;
		System.out.println(" inside sendEmail method "+emailid);
		
		final String from = "nidhinayakwork26@gmail.com";
		String to = emailid;
		final String password = "work24/7";
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
			message.setSubject("Aurora Bank");
			message.setText(" Your OTP is : "+optsentinmail);
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} 
		catch (MessagingException e) {  System.out.println(e); 
		}
	}
	
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
	
	public String checkOtp(int otp)
	{
		otpfromuser= otp;
		System.out.println(otpfromuser);
		
		if( otpfromuser == otpgeneratedbyfunction )
		{
			ret ="setnewpassword.jsp";
		}
		else
		{
			ret ="errwrngotp.jsp";
		}
		return ret;
	}
	
	public String setLoginPasswordByUser(String lpass,int globaluserid)
	{
		System.out.println("Inside Set Password forgot pass controller.................");
		ret=forgotpasswordDao.setLoginPasswordByUser(lpass,globaluserid);
		return ret;
	}
	}

