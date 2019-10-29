package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao 
{
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	String ret="";

	public String loginDetailsEnteredByUser(int userid,String password)throws NoResultException
	{
		String ql = "select accno from Registerib r where r.userid = :userid and r.loginpass=:password";
		Query q = entityManager.createQuery(ql);
		q.setParameter("userid", userid);
		q.setParameter("password", password);
		System.out.println("Inside LoginDao Controller.........");
		try
		{
			System.out.println("Inside try.........");
			int accno = (Integer) q.getSingleResult();
			System.out.println(accno);
			ret = "dashboard.jsp";
		}
		catch(Exception e)
		{
			System.out.println("Inside catch block");
			e.printStackTrace();
			ret = "errorlogin.jsp";
		}
		return ret;
	}
	public String getName(int userid)
	{
		String ql = "select accno from Registerib r where r.userid = :userid";
		Query q = entityManager.createQuery(ql);
		q.setParameter("userid", userid);
		int accno = (Integer) q.getSingleResult();
		
		String q2 = "select fname from Customer c where c.accno = :accno";
		Query q3 = entityManager.createQuery(q2);
		q3.setParameter("accno", accno);
		String fname = (String) q3.getSingleResult();
		return fname;
	}
	
}
