package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.lti.entity.Admin;
import com.lti.entity.Customer;
import com.lti.service.AdminService;

@Controller
public class AdminContoller 
{
	@Autowired
	private AdminService adminService;
	
	public List<Admin> fetchDataForAdmin()
	{
		return adminService.fetchDataForAdmin();
		 
	}
	public void adminApprovedNowSendMail( int accno, String emailid )  
	{
		adminService.adminApprovedNowSendMail( accno,emailid );
	}
	
	public void sendRejetctMail(int accno, String emailid,String msg) 
	{
		adminService.sendRejetctMail( accno,emailid,msg );
	}
	public void customerDetailsForAdmin( int accno )
	{
		adminService.customerDetailsForAdmin( accno );
	}
}
