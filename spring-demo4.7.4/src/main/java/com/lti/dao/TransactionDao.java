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
	int checkiftheuseralreadyexists;
	int newtid;
	int availablebalancefromprevioustransaction;
	
	@Transactional
	public List<BeneficiaryDetails> dropDownForBeneficiary( int userid )
	{
		//System.out.println("enterred TransactionDao ");
		Query q = entityManager.createNativeQuery("select b.beneficiaryaccno from BENEFICIARYDETAILS01 b where b.userid=:userid");
		q.setParameter( "userid", userid );
		
		 List<BeneficiaryDetails> bd= q.getResultList(); 
		 /*ListIterator<BeneficiaryDetails> iterator = bd.listIterator();
		 while (iterator.hasNext()) 
		 { 
			 System.out.println("Value is : "+iterator.next()); 
		}*/
		//System.out.println("leaving TransactionDao");
		return bd;
	}
	
	@Transactional
	public String initiateImps( Transaction transaction, int userid )
	{	
		int r = checkIfTheUserAlreadyExists( transaction, userid );
		if( r == -1)
		{
			doTransactionForFirstTime( transaction, userid );
			newtid = getNewTid( transaction, userid);
			updateAvailableBalance( transaction, newtid );
		}
		else
		{
			doTransactionForOldUser( transaction, userid );
			newtid = getNewTidForOldUser( transaction, userid);
			updateAvailableBalanceForOldUser( transaction, newtid );
		}
		return "dashboard.jsp";
	}
	
	@Transactional
	public int checkIfTheUserAlreadyExists( Transaction transaction, int userid ) 
	{
		Query q = entityManager.createQuery("select distinct(t.tid) from Transaction t where exists (select t.tid from Transaction t where t.refuserid=:userid)");
		q.setParameter( "userid", userid );
		
		List l = q.getResultList();
		ListIterator  iterator = l.listIterator();
		
		 while (iterator.hasNext()) 
		 { 
			 checkiftheuseralreadyexists = (Integer) iterator.next(); 
		 }
		 if( checkiftheuseralreadyexists == 0 )
		 { return -1; }
		 else
		 { return 1; }
	}
	
	@Transactional
	public void doTransactionForFirstTime( Transaction transaction, int userid  )
	{
		transaction.setRefuserid(userid);
		transaction.setBalance(10000);
		transaction.setAvailablebalance(10000);
		transaction.setTransactiondate(new Date());
		transaction.setTransactiontime(new Date());
		entityManager.merge(transaction);
	}

	@Transactional
	public int getNewTid( Transaction transaction, int userid)
	{
		Query q = entityManager.createQuery("select t.tid from Transaction t where t.refuserid=:refuserid");
		q.setParameter( "refuserid", userid );
		int newtid = (Integer) q.getSingleResult();
		return newtid;
	}
	
	@Transactional
	public void updateAvailableBalance( Transaction transaction, int newtid  ) 
	{
		Query q= entityManager.createQuery( "UPDATE Transaction t SET t.availablebalance = t.availablebalance - :transactionamount  WHERE t.tid = :tid");
		q.setParameter( "transactionamount", transaction.getTransactionamt());
		q.setParameter("tid", newtid);
		q.executeUpdate();
	}
	
	@Transactional
	public void doTransactionForOldUser( Transaction transaction, int userid )
	{
		transaction.setRefuserid(userid);
		availablebalancefromprevioustransaction = getAvailableBalanceFromPreviousTransaction( userid );
		if(availablebalancefromprevioustransaction!=-1)
		{
			transaction.setBalance(availablebalancefromprevioustransaction);
		}
		//System.out.println(transaction.getAvailablebalance());
		transaction.setTransactiondate(new Date());
		transaction.setTransactiontime(new Date());
		entityManager.merge(transaction);
	}
	
	@Transactional
	public int getAvailableBalanceFromPreviousTransaction( int userid ) throws NoResultException
	{
		try
		{	
			Query q = entityManager.createNativeQuery("select AVAILABLEBALANCE from Transaction01 where tid = ( select max(tid) from Transaction01 where refuserid=:userid )");
			q.setParameter("userid", userid );
			String s = q.getSingleResult().toString();
			availablebalancefromprevioustransaction = Integer.parseInt( s );		
			System.err.println("insidet try availablebalancefromprevioustransactionis : "+availablebalancefromprevioustransaction);

		}
		catch(NoResultException nre)
		{ 	
			System.out.println(nre);
			Query q1 = entityManager.createNativeQuery("select AVAILABLEBALANCE from Transaction01 where tid = ( select max(tid) from Transaction01 where refuserid=:userid )");
			q1.setParameter("userid", userid );
			String s = q1.getSingleResult().toString();
			availablebalancefromprevioustransaction = Integer.parseInt( s );
			System.err.println("catch availablebalancefromprevioustransactionis : "+availablebalancefromprevioustransaction);
		}
		return availablebalancefromprevioustransaction;
	}
	
	@Transactional
	public int getNewTidForOldUser ( Transaction transaction, int userid )
	{
		Query q = entityManager.createQuery("select t.tid from Transaction t where t.refuserid=:refuserid and t.availablebalance=0");
		q.setParameter( "refuserid", userid );
		int newtid = (Integer) q.getSingleResult();
		//System.out.println("new tid for old user is : "+newtid);
		return newtid;
	}
	
	@Transactional
	public void updateAvailableBalanceForOldUser( Transaction transaction, int newtid )
	{
		Query q= entityManager.createQuery( "UPDATE Transaction t SET t.availablebalance = t.balance - :transactionamount  WHERE t.tid = :tid");
		q.setParameter( "transactionamount", transaction.getTransactionamt());
		q.setParameter("tid", newtid);
		q.executeUpdate();
	}
	
}













