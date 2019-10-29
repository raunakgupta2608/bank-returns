package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class ForgotUseridDao {
	@PersistenceContext	
	private EntityManager entityManager;
	int accountno;
	String ret="";
	
	@Transactional
	public int chkAccountNumberForUserid(int accno)throws NoResultException 
	{
		accountno=accno;
		System.out.println("enterred customer dao");
		Query q = entityManager.createQuery("select c.aadharno from Customer c  where c.accno = :accnno"); 
		q.setParameter("accnno", accno);
		try 
		{
			int aadhar = (Integer) q.getSingleResult();
			System.out.println("aadhar is : "+aadhar);
			System.out.println("leaving try forgotuserid dao");
			return 1;
		}
		catch(NoResultException nre)
		{
			System.out.println("leaving catch forgotuserid dao");
			return -1;
		}
	}
	
	public String getEmailId()
	{
		String email="";
		String ql="Select emailid from Customer c  where c.accno=:accno";
		Query q=entityManager.createQuery(ql);
		q.setParameter("accno",accountno);
		email=(String) q.getSingleResult();
		System.out.println(email);
		return email;
	}
	public int getUserid()
	{
		int userid=0;
		String ql="Select userid from Registerib r where r.accno=:accno";
		Query q=entityManager.createQuery(ql);
		q.setParameter("accno",accountno);
		userid=(Integer)q.getSingleResult();
		System.out.println(userid);
		return userid;
	}
}
