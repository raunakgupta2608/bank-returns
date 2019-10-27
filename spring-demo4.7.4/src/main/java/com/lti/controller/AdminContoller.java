package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.entity.Admin;
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
	public void adminApprovedNowSendMail()
	{
		adminService.adminApprovedNowSendMail();
	}
}
