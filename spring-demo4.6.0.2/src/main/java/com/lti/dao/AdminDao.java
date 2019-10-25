package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.ListIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.lti.entity.Admin;
import com.lti.entity.Customer;

@Repository
public class AdminDao 
{
	@PersistenceContext
	private EntityManager entityManager;

	
	@Transactional
	public void saveCustomerDataIntoAdminDatabase(Customer customer,Admin admin) 
	{
		fetchDataFromCustomerObject(customer,admin);
		entityManager.merge(admin); // both insert and update
	}
	public void fetchDataFromCustomerObject(Customer customer,Admin admin)
	{
		int aadhar = customer.getAadharno();
		Query q = entityManager.createQuery("select accno from Customer c  where c.aadharno = :aadhar");
		q.setParameter("aadhar", aadhar);
		int accno = (Integer) q.getSingleResult();
		admin.setAccno(accno);
		admin.setEmailid(customer.getEmailid());
	}
	
	
	public List<Admin> fetchDataForAdmin(  )
	{
		System.out.println("enterred admin dao");
		String q1= "select a from Admin a where a.status=0";
		Query q =entityManager.createQuery(q1);
		
		/*
		 * List<Admin> admindata = q.getResultList(); ListIterator<Admin> iterator =
		 * admindata.listIterator();
		 * 
		 * while (iterator.hasNext()) { System.out.println("Value is : "+
		 * iterator.nextIndex() ); }
		 */
		System.out.println("leaving admin dao");
		return q.getResultList();
	}
	
	public List<String> getEmail()
	{
		System.out.println("enterred admin dao getEmail()");
		String q1= "select emailid from Admin a where a.status=0";
		Query q =entityManager.createQuery(q1);
		
		
		  /*List<Admin> admindata =*/  
		  /*ListIterator<Admin> iterator = admindata.listIterator();
		  
		  while (iterator.hasNext()) 
		  { 
			  System.out.println("Value is : "+ iterator.next() ); 
		  } 
		  System.out.println("leaving admin dao getEmail()");*/
		 
		return q.getResultList();
	}
	@Transactional
	public void updateStatus()
	{
		System.out.println("enterred admin dao updateStatus()");
		String q1= "UPDATE Admin a SET a.status = 1 WHERE a.status = 0";
		Query q =entityManager.createQuery(q1);
		int rowsUpdated = q.executeUpdate();
		System.out.println( rowsUpdated );
		
	}
	
	public int getAccno( String emailid  ) 
	{
		System.out.println("enterred admin dao getAccno");
		Query q = entityManager.createQuery("select accno from Admin a where a.emailid =:emailid");
		q.setParameter("emailid", emailid);
		int accno = (Integer) q.getSingleResult();
		return accno;
	}
	
}
