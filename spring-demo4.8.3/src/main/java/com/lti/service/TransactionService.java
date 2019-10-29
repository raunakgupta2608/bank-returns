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
	
	//////////////////////////////////////
	
////////////////////////////////////////
	
	public int getTransactionId( int tid )
	{
		return transactionDao.getTransactionId( tid );
	}
	public int getBeneficiaryAccNo( int tid  )
	{
		return transactionDao.getBeneficiaryAccNo( tid );
	}
	public int getBalance( int tid  )
	{
		return transactionDao.getBalance( tid );
	}
	public int getTransactionAmount( int tid )
	{
		return transactionDao.getTransactionAmount( tid  );
	}
	public int getAvailableBalance( int tid  )
	{
		return transactionDao.getAvailableBalance( tid );
	}
}
