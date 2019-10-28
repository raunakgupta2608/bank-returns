package com.lti.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.lti.entity.BeneficiaryDetails;
import com.lti.entity.Transaction;
import com.lti.service.TransactionService;

@Controller
public class TransactionContoller 
{
	@Autowired
	private TransactionService transactionService;
	
	String ret="";
	
	public List<BeneficiaryDetails> dropDownForBeneficiary( int userid )
	{
		return transactionService.dropDownForBeneficiary( userid );
		 
	}
	public String initiateImps( Transaction transaction, int userid  )
	{
		ret = transactionService.initiateImps( transaction, userid );
		return ret;
	}
	public int getTransactionId(  )
	{
		return transactionService.getTransactionId();
	}
	public int getBeneficiaryAccNo()
	{
		return transactionService.getBeneficiaryAccNo();
	}
	public int getBalance()
	{
		return transactionService.getBalance();
	}
	public int getTransactionAmount()
	{
		return transactionService.getTransactionAmount();
	}
	public int getAvailableBalance()
	{
		return transactionService.getAvailableBalance();
	}
}
