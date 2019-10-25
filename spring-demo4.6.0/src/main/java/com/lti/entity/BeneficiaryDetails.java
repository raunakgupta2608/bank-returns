package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="beneficiarydetails01")
public class BeneficiaryDetails 
{
	@Id
	private CompositeKey compositekey;
	
	@Column(name="beneficiaryaccno")
	private int beneficiaryaccno;
	@Column(name="beneficiaryname")
	private String beneficiaryname;
	@Column(name="nickname")
	private String nickname;

	public int getBeneficiaryaccno() {
		return beneficiaryaccno;
	}

	public void setBeneficiaryaccno(int beneficiaryaccno) {
		this.beneficiaryaccno = beneficiaryaccno;
	}

	public String getBeneficiaryname() {
		return beneficiaryname;
	}

	public void setBeneficiaryname(String beneficiaryname) {
		this.beneficiaryname = beneficiaryname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public CompositeKey getCompositekey() {
		return compositekey;
	}

	public void setCompositekey(CompositeKey compositekey) {
		this.compositekey = compositekey;
	}
	
	
	
	
}
