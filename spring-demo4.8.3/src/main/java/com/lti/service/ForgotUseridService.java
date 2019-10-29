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

import com.lti.dao.ForgotUseridDao;
@Service
public class ForgotUseridService {
	String ret="";
	String email="'";
	int otpgeneratedbyfunction;
	int otpfromuser;
	int userid;
	@Autowired
	private ForgotUseridDao forgotUseridDao;
	public String chkAccountNumberForUserid(int accno)
	{
		System.out.println("entering service checkaccnoforgotuser");
		int flag=forgotUseridDao.chkAccountNumberForUserid(accno);
		if(flag==1)
		{
			getEmail();
			ret="enterotpforforgotuserid.jsp";
		}
		else
		{
			ret="errwrngaccno.jsp";
		}
	return ret;
}
	public void getEmail()
	{
		email=forgotUseridDao.getEmailId();
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
	public String chkOtpForUserid(int otp)
	{
		otpfromuser=otp;
		if(otpfromuser==otpgeneratedbyfunction)
		{
			getUser();
			ret="userlogin.jsp";
		}
		else
		{
			ret="errwrngotp.jsp";
		}
		return ret;
	}
	public void getUser()
	{
		userid=forgotUseridDao.getUserid();
		email=forgotUseridDao.getEmailId();
		sendUseridMail(userid,email);
	}
	public void sendUseridMail(int userid,String email)
	{
		int uid=userid;
		String emailid = email;
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
			message.setSubject("Aurora Bank");
			message.setText(" Your USERID is : "+uid);
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} 
		catch (MessagingException e) {  System.out.println(e); 
		}
	}

}
