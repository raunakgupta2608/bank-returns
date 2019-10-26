package com.lti.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Admin;
import com.lti.entity.Customer;

@Repository
public class CustomerDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private AdminDao admindao;
	
	
	@Transactional
	public int openSavingAccount(Customer customer, Admin admin) 
	{
		 dateCompute(customer);
		 entityManager.merge(customer); // both insert and update
		 int aadharno = customer.getAadharno();
		 int accno = fetchAccno( aadharno );
		 admindao.saveCustomerDataIntoAdminDatabase(customer, admin);
		 return accno;
	}
	
	public void dateCompute(Customer customer)
	{
		String inputdate = customer.getDob();
	    String year ="";
	    String month ="";
	    String date ="";

	        int i=0;
            while(i<4)
	        {
	            year =year + inputdate.charAt(i);
	            i++;     
	        }
	        i=5;
	        while(i>4 && i<7)
	        {
	            month =month + inputdate.charAt(i);
	            i++;     
	        }
            i=8;
	        while( i>7 && i<10 )
	        {
	            date =date + inputdate.charAt(i);
	            i++;     
	        }
	        i=0;
	        inputdate = date +"-"+ month +"-"+year;
	        customer.setDob(inputdate);
	}
	
	/*
	 * public static void dateCompute(Customer customer) {
	 * 
	 * Date d = customer.getDob(); 
	 * SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy"); 
	 * String ddMMyyyy = date_format.format(d);
	 * customer.setDob(ddMMyyyy);
	 * 
	 * String date = customer.getDob(); String formateddate =""; for(int i =
	 * date.length() - 1; i >= 0; i--) { if(charAt(i)!='-') { formateddate =
	 * formateddate + date.charAt(i); } } System.out.println(formateddate);
	 * 
	 * String pattern = "dd-M-yyyy"; SimpleDateFormat simpleDateFormat = new
	 * SimpleDateFormat(pattern); String date =
	 * simpleDateFormat.format(customer.getDob()); customer.setDob(date);
	 * System.out.println(date); }
	 */
	 
	
	public int fetchAccno( int aadharno) 
	{
		Query q = entityManager.createQuery("select accno from Customer c  where c.aadharno = :aadharno");
		q.setParameter("aadharno", aadharno);
		int accno = (Integer) q.getSingleResult();
		return accno;
	}

	/*public List<Customer> fetchAll() {
		String q1 = "select c from Customer c";
		Query q = entityManager.createQuery(q1);
		return q.getResultList();

	}*/
	
	/*
	 * public static void validate(Customer customer) {
	 * System.out.println(customer.getaadharnono());
	 * System.out.println(customer.getDob());
	 * System.out.println(customer.getMobileno()); }
	 */
}
