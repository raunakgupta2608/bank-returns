package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.entity.Admin;
import com.lti.entity.Customer;
import com.lti.service.CustomerService;

@Controller
public class CustomerContoller 
{
	@Autowired
	private CustomerService customerService;
	
	public void openSavingAccount(Customer customer, Admin admin) 
	{
		customerService.openSavingAccount(customer,admin);
	}
}
