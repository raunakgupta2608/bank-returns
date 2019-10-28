package com.lti.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lti.dao.TransactionDao;
import com.lti.entity.BeneficiaryDetails;
import com.lti.entity.Transaction;

@Service
public class TransactionService 
{
	@Autowired
	private TransactionDao transactionDao;
	
	String ret="";
	
	public List<BeneficiaryDetails> dropDownForBeneficiary( int userid )
	{
		return transactionDao.dropDownForBeneficiary( userid );
	}
	public String initiateImps( Transaction transaction, int userid  )
	{
		ret = transactionDao.initiateImps( transaction, userid );
		return ret;
	}
	public int getTransactionId(  )
	{
		return transactionDao.getTransactionId();
	}
	public int getBeneficiaryAccNo()
	{
		return transactionDao.getBeneficiaryAccNo();
	}
	public int getBalance()
	{
		return transactionDao.getBalance();
	}
	public int getTransactionAmount()
	{
		return transactionDao.getTransactionAmount();
	}
	public int getAvailableBalance()
	{
		return transactionDao.getAvailableBalance();
	}
}
