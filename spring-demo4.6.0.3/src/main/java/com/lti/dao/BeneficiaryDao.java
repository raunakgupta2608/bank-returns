package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.BeneficiaryDetails;
import com.lti.entity.CompositeKey;
import com.lti.entity.Transaction;

@Repository
public class BeneficiaryDao 
{
	@PersistenceContext
	private EntityManager entityManager;
	
	String ret="";
	int retint;
	
	@Transactional
	public String saveBeneficiaryDetails( BeneficiaryDetails beneficiarydetails, CompositeKey compositekey, int userid  )
	{
		
		int beneficiaryaccno =  compositekey.getBeneficiaryaccno();
		System.out.println("inside bene dao beneaccno is "+beneficiaryaccno);
		retint = checkForValidity( beneficiaryaccno );
		if( retint == 1)
		{
			 entityManager.merge( beneficiarydetails ); // both insert and update
			 ret = "dashboard.jsp";
		}
		else
		{
			ret= "addpayee.lti";
		}
		return ret;
	}
	
	public int checkForValidity( int beneficiaryaccno )
	{
		Query q = entityManager.createQuery("select aadharno from Customer c  where c.accno = :accno");
		q.setParameter("accno", beneficiaryaccno);
		
		try
		{
			int aadharno = (Integer) q.getSingleResult();
			System.out.println("aadharno is : " +aadharno);
			System.out.println("leaving beneficiary dao");
			retint= 1;
		}
		catch(NoResultException nre)
		{
			System.out.println("leaving catch registerib dao");
			retint = -1;
		}
		return retint;
	}
}
