package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.entity.BeneficiaryDetails;
import com.lti.entity.CompositeKey;
import com.lti.service.BeneficiaryService;

@Controller
public class BeneficiaryController 
{
	@Autowired
	private BeneficiaryService beneficiaryService;
	
	String ret ="";
	
	public String saveBeneficiaryDetails( BeneficiaryDetails beneficiarydetails, CompositeKey compositekey, int userid  )
	{
		ret = beneficiaryService.saveBeneficiaryDetails( beneficiarydetails, compositekey, userid );
		return ret;
	}
}
