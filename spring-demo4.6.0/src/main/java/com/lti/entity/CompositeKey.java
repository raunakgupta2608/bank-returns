package com.lti.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompositeKey implements Serializable
{
	private int beneficiaryaccno;
	private int userid;
	
	public CompositeKey(int beneficiaryaccno, int userid) {
		super();
		this.beneficiaryaccno = beneficiaryaccno;
		this.userid = userid;
	}
	public int getBeneficiaryaccno() {
		return beneficiaryaccno;
	}
	public void setBeneficiaryaccno(int beneficiaryaccno) {
		this.beneficiaryaccno = beneficiaryaccno;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
}
