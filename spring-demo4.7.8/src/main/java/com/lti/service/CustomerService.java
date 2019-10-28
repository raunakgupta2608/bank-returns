package com.lti.service;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lti.entity.Admin;
import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;


@Service
//business logic
public class CustomerService 
{
			@Autowired
			private CustomerDao customerDao;
			
			public void openSavingAccount(Customer customer, Admin admin) 
			{
				int accno = customerDao.openSavingAccount(customer,admin); //ask the dao to save it in the db
				//sending emailcode here
				
		/* getEmail(); */ 
		/* int accno = customerDao.fetchAccno(); */
				sendEmail( accno, customer );
				
				
			}
//////////////////////////////////////////////////////////////////////////////////////////		
			public void sendEmail( int accno, Customer customer )
			{
				
				String emailid = customer.getEmailid();
				System.out.println(" inside sendEmail method "+emailid);
				
				final String from = "nidhinayak26@gmail.com";
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
					message.setText("Your request has been sent to admin for approval. After admin's approval, you will receive account number through email");
					// send message
					Transport.send(message);
					System.out.println("message sent successfully");
				} 
				catch (MessagingException e) {  System.out.println(e); }
			}
			

/////////////////////////////////////////////////////////////////////////////////////////			
			/*public String getEmail(String email)	
			{
				customerDao.fetchEmail(email);
				return 				
			}*/
	/*
	 * int aadharno = customer.get public int getAccno( ) { return
	 * customerDao.fetchAccno(); }
	 */
}
