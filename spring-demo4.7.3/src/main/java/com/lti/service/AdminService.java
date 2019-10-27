package com.lti.service;

import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lti.dao.AdminDao;
import com.lti.dao.CustomerDao;
import com.lti.entity.Admin;
import com.lti.entity.Customer;

@Service
public class AdminService 
{
	@Autowired
	private AdminDao adminDao;
	
	String emailid="";
	
	public List<Admin> fetchDataForAdmin( )
	{
		return adminDao.fetchDataForAdmin();
	}
	public void adminApprovedNowSendMail()
	{
		System.out.println("enterred admin service adminApprovedNowSendMail()");
		getEmail();
		
	}
	public void getEmail()
	{
		System.out.println("enterred admin service getEmail()");
		List<String> listofemails = adminDao.getEmail();
		ListIterator<String> iterator = listofemails.listIterator();
		while (iterator.hasNext())
		{
			 String s = iterator.next(); 
			 System.out.println("Emailid before sending mail : "+s); 
			sendEmail( s );
		}
		adminDao.updateStatus();
	}
	public void sendEmail( String email)
	{
		
		String emailid = email;
		int accno = adminDao.getAccno(emailid );
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
			message.setText(" Your Account number is : "+accno);
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} 
		catch (MessagingException e) {  System.out.println(e); }
	}
}
