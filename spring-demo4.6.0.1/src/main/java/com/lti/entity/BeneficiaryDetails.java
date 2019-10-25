package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="beneficiarydetails01")
public class BeneficiaryDetails 
{
	@EmbeddedId
	private CompositeKey compositekey;
	
	@Column(name="beneficiaryname")
	private String beneficiaryname;
	@Column(name="beneficiarynickname")
	private String beneficiarynickname;

	@OneToOne( cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Registerib registerib;

	public String getBeneficiaryname() {
		return beneficiaryname;
	}

	public void setBeneficiaryname(String beneficiaryname) {
		this.beneficiaryname = beneficiaryname;
	}

	public String getbeneficiarynickname() {
		return beneficiarynickname;
	}

	public void setbeneficiarynickname(String beneficiarynickname) {
		this.beneficiarynickname = beneficiarynickname;
	}

	public CompositeKey getCompositekey() {
		return compositekey;
	}

	public void setCompositekey(CompositeKey compositekey) {
		this.compositekey = compositekey;
	}
	
	
	
	
}
