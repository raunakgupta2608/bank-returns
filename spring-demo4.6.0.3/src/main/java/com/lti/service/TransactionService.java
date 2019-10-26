package com.lti.service;

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

}
