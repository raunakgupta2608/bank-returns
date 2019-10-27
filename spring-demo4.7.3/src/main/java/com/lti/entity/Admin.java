package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="admin01")
public class Admin 
{
	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO, generator ="requestidseq" )
/*	@SequenceGenerator ( name ="requestidseq", initialValue=1000000, allocationSize=1,sequenceName="requestid")
	@GeneratedValue ( strategy = GenerationType.SEQUENCE, generator ="requestidseq" )*/
	@Column(name="requestid")
	private int requestid;
	@Column(name="accno")
	private int accno;
	@Column(name="emailid")
	private String emailid;
	@Column(name="status", columnDefinition = "integer default 0")
	private int status;
	
	public int getRequestid() {
		return requestid;
	}
	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	
	
}
