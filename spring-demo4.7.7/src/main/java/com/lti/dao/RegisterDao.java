package com.lti.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.lti.entity.Registerib;

@Repository
public class RegisterDao 
{
	@PersistenceContext
	private EntityManager entityManager;
	
	int accnofromthisrequest;
	
	@Transactional
	public void saveDataFromFirstAndSecondRequest( Registerib secondreqobj ) 
	{
		System.out.println("entering dao saveDataFromFirstAndSecondRequest");
		entityManager.merge( secondreqobj );
		System.out.println("leaving dao saveDataFromFirstAndSecondRequest");
	}
	
	//fucntion to fetch list of data from database
	
	/*@Transactional
	public void saveAccountNumberFromRegisterIBPage(Registerib registerib)
	{
		Query q = entityManager.createQuery("select accno from Registerib r  ");
		List<Registerib> accnolist  = ( List<Registerib> )  q.getResultList();
		entityManager.merge(registerib);
	}*/
	public int checkAccountNumberFromRegisterIbTable( int accnofromfirstrequest ) throws NoResultException
	{
		System.out.println("enterred registerib dao");
		Query q = entityManager.createQuery("select userid from Registerib r  where r.accno = :accnno");
		q.setParameter("accnno", accnofromfirstrequest);
		try
		{
			int userid = (Integer) q.getSingleResult();
			System.out.println("userid is : " +userid);
			System.out.println("leaving registerib dao");
			return -1;
		}
		catch(NoResultException nre)
		{
			System.out.println("leaving catch registerib dao");
			return 1;
		}
		
	}
	public int checkAccountNumberFromCustomerDetailsTable( int accnofromfirstrequest) throws NoResultException
	{
		accnofromthisrequest = accnofromfirstrequest;
		System.out.println("enterred customer dao");
		Query q = entityManager.createQuery("select aadharno from Customer c  where c.accno = :accnno"); 
		q.setParameter("accnno", accnofromfirstrequest);
		try 
		{
			int aadhar = (Integer) q.getSingleResult();
			System.out.println("aadhar is : "+aadhar);
			System.out.println("leaving try customer dao");
			return 1;
		}
		catch(NoResultException nre)
		{
			System.out.println("leaving catch customer dao");
			return -1;
		}
	}
	
	@Transactional
	public void saveDataFromFirstAndSecondAndThirdRequest( Registerib thirdreqobj ) 
	{
		System.out.println("entering dao saveDataFromFirstAndSecondAndThirdRequest");
		entityManager.merge( thirdreqobj );
		System.out.println("leaving dao saveDataFromFirstAndSecondAndThirdRequest");
	}
	
	//function to update password 
	
/*	@Transactional
	public void savePasswordFromSetPasswordPage(Registerib registerib)
	{
		int accno = registerib.getAccno();
		
		
		String loginpass = registerib.getLoginpass();
		String transpass = registerib.getTranspass();
		Query q = entityManager.createQuery("update Registerib r set  loginpass =:loginpass, transpass =:transpass  where r.accno = :accnno"); 
		q.setParameter("accnno", accno);
		q.setParameter("loginpass", loginpass);
		q.setParameter("transpass", transpass);
		q.getSingleResult();
		entityManager.merge(registerib);
	}*/
	
	/*
	 * public int getAccountNumber(Registerib registerib) throws NoResultException {
	 * System.out.println("enterred dao"); int accno = registerib.getAccno(); Query
	 * q = entityManager.
	 * createQuery("select aadharno from Customer c  where c.accno = :accnno");
	 * q.setParameter("accnno", accno); try { int aadhar = (Integer)
	 * q.getSingleResult(); System.out.println(aadhar);
	 * System.out.println("leaving dao"); return 1; } catch(NoResultException nre) {
	 * System.out.println("leaving catch dao"); return -1; } }
	 */
	
	public String getEmail( Registerib secondreqobj )
	{	
		System.out.println("enterred register dao getEmail");
		System.out.println("accno from register dao getEmai "+accnofromthisrequest);
		Query q = entityManager.createQuery("select emailid from Customer  c where c.accno =:accno");
		q.setParameter("accno", accnofromthisrequest);
		String email = ( String ) q.getSingleResult();
		System.out.println("leaving register dao getEmail "+email);
		return email;
	}
}
