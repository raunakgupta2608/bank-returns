package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.BeneficiaryDetails;
import com.lti.entity.CompositeKey;

@Repository
public class BeneficiaryDao 
{
	@PersistenceContext
	private EntityManager entityManager;
	
	String ret="";
	int retint;
	
	public String saveBeneficiaryDetails( BeneficiaryDetails beneficiarydetails, CompositeKey compositekey, int userid  )
	{
		int beneficiaryaccno =  beneficiarydetails.getBeneficiaryaccno();
		retint = checkForValidity( beneficiaryaccno );
		if( retint == 1)
		{
			 entityManager.merge( beneficiarydetails ); // both insert and update
			 ret = "dashborad.jsp";
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
		/*int aadharno = (Integer) q.getSingleResult();*/
		
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
