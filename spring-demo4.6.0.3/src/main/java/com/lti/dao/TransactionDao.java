package com.lti.dao;

import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Admin;
import com.lti.entity.BeneficiaryDetails;
import com.lti.entity.Transaction;

@Repository
public class TransactionDao 
{
	@PersistenceContext
	private EntityManager entityManager;
	
	String ret="";
	int re;
	
	@Transactional
	public List<BeneficiaryDetails> dropDownForBeneficiary( int userid )
	{
		System.out.println("enterred TransactionDao ");
		Query q = entityManager.createNativeQuery("select b.beneficiaryaccno from BENEFICIARYDETAILS01 b where b.userid=:userid");
		q.setParameter( "userid", userid );
		
		 List<BeneficiaryDetails> bd= q.getResultList(); 
		 ListIterator<BeneficiaryDetails> iterator = bd.listIterator();
		 while (iterator.hasNext()) 
		 { 
			 System.out.println("Value is : "+iterator.next()); 
		}
		System.out.println("leaving TransactionDao");
		return bd;
	}
	@Transactional
	public String initiateImps( Transaction transaction, int userid )
	{	
		System.out.println("entereed  dao initiateImps");
		int transactionamt = transaction.getTransactionamt();
		
			int plusorminus = checkForFirstTimeTransaction(userid);
			if( plusorminus == -1)
			{
				if( transactionamt <=10000 )
				{
					doTransaction( transaction, userid );
					ret = "dashboard.jsp";
				}
				else
				{ ret = "imps.jsp"; }
			}
			else
			{
				int availablebalance = transaction.getAvailablebalance();
				if( transactionamt <= availablebalance )
				{
					doTransaction( transaction, userid );
					ret = "dashboard.jsp";
				}
				else
				{ ret = "imps.jsp"; }
			}
		return ret;
	}
	
	@Transactional
	public int checkForFirstTimeTransaction(  int userid ) throws NoResultException
	{
		try
		{
			Query q = entityManager.createQuery("select balance from Transaction where refuserid=:userid");
			q.setParameter( "userid", userid );
			q.getResultList();
			//System.out.println(balance);
			re = 1;
		}
		catch(NoResultException nre )
		{
			System.out.println(nre);
			re = -1;
		}
		return re;
	}
	
	@Transactional
	public void doTransaction(  Transaction transaction, int userid )
	{
		System.out.println("entereed doTransaction");
		transaction.setRefuserid(userid);
		int beneficiaryaccno = transaction.getRefbeneficiaryaccno();
		System.out.println(beneficiaryaccno);
		/*Query q = entityManager.createNativeQuery("select beneficiaryname from Beneficiarydetails01 where beneficiaryaccno=:beneficiaryaccno");
		q.setParameter("beneficiaryaccno", beneficiaryaccno);
		String beneficiaryname = (String) q.getSingleResult();
		transaction.setToname( beneficiaryname );*/
		transaction.setTransactiondate(new Date());
		transaction.setTransactiontime(new Date());
		
		
		Transaction transaction1 =updateBalance( transaction.getTransactionamt(), userid,transaction );
		
		
		
		entityManager.merge(transaction1);
		ret="dashboard.jsp";
	}
	
	@Transactional
	public Transaction updateBalance( int transactionamount, int refuserid, Transaction transaction ) throws NoResultException
	{
		System.out.println("entered dao updateBalance");
		System.out.println("*********************************");
		System.out.println("balance before update is :"+transactionamount);
		Query q= entityManager.createQuery( "UPDATE Transaction t SET t.availablebalance = t.availablebalance - :transactionamount  WHERE t.refuserid = :refuserid");
		q.setParameter( "transactionamount", transactionamount);
		q.setParameter("refuserid", refuserid);
		int rowsUpdated = q.executeUpdate();
		System.out.println("updateBalance rowsUpdated"+rowsUpdated);
		
		
		try
		{
			Query q1 = entityManager.createQuery("select t.availablebalance from Transaction t  where t.refuserid = :refuserid");
			q1.setParameter("refuserid",  refuserid);
			int balanceafterupdate = (Integer) q1.getSingleResult();
			transaction.setBalance(balanceafterupdate);
		}
		catch(NoResultException nre)
		{ System.out.println(nre); }
		return transaction;
	}
}











/*if( transactionamt <=10000 )
{
	//System.out.println("Inside transaction dao if loop");
	transaction.setRefuserid(userid);
	//System.out.println(" refuserid after setting is : "+transaction.getRefuserid());
	int beneficiaryaccno = transaction.getRefbeneficiaryaccno();
	//System.out.println("beneficiary accno is :" +beneficiaryaccno);
	Query q = entityManager.createNativeQuery("select beneficiaryname from BENEFICIARYDETAILS01 where beneficiaryaccno=:beneficiaryaccno");
	q.setParameter( "beneficiaryaccno", beneficiaryaccno );
	String beneficiaryname = (String) q.getSingleResult();
	transaction.setToname( beneficiaryname );
	transaction.setTransactiondate(new Date());
	transaction.setTransactiontime(new Date());
	entityManager.merge(transaction); 
	ret="dashboard.jsp";
}
else 
{  ret = "imps.jsp"; }*/
