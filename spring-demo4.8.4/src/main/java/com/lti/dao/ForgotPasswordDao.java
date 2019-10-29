package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class ForgotPasswordDao {
@PersistenceContext	
private EntityManager entityManager;
String ret="";
int accno;

	public int checkUserId(int userid)throws NoResultException 
	{
		String ql="Select accno from Registerib r where r.userid=:uid";
		Query q=entityManager.createQuery(ql);
		q.setParameter("uid",userid);
		try {
			accno=(Integer)q.getSingleResult();
			System.out.println(accno);
			return 1;
			}
		
		catch(Exception e)
		{
			System.out.println("Inside catch block");
			e.printStackTrace();
			return 0;
		}

	}
	
	public String getEmailId()
	{
		String email="";
		String ql="Select emailid from Customer c  where c.accno=:accno";
		Query q=entityManager.createQuery(ql);
		q.setParameter("accno",accno);
		email=(String) q.getSingleResult();
		System.out.println(email);
		return email;
	}
	/*public void updateStatus()
	{
		System.out.println("enterred admin dao updateStatus()");
		String q1= "UPDATE Admin a SET a.status = 1 WHERE a.status = 0";
		Query q =entityManager.createQuery(q1);
		int rowsUpdated = q.executeUpdate();
		System.out.println( rowsUpdated );
	}	*/
	@Transactional
	public String setLoginPasswordByUser(String lpass,int globaluserid)
	{
		String q1= "UPDATE  Registerib r SET r.loginpass = :loginpass WHERE r.userid =:userid";
		Query q =entityManager.createQuery(q1);
		q.setParameter("loginpass", lpass);
		q.setParameter("userid", globaluserid);
		int rowsUpdated = q.executeUpdate();
		System.out.println( rowsUpdated );
		return ret;
	}
}
