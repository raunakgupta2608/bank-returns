package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="customerdetails01")
public class Customer 
{

	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO, generator ="customersequence")
/*	@SequenceGenerator( name ="customersequence", initialValue=1000, allocationSize=1, sequenceName="account")
	@GeneratedValue ( strategy = GenerationType.SEQUENCE, generator ="customersequence")*/
	@Column(name="accno")
	private int accno;
	@Column(name="title")
	private String title;
	@Column(name="fname")
	private String fname;
	@Column(name="mname")
	private String mname;
	@Column(name="lname")
	private String lname;
	@Column(name="fathername")
	private String fathername;
	@Column(name="mobileno")
	private int mobileno;
	@Column(name="emailid")
	private String emailid;
	@Column(name="aadharno", unique=true)
	private int aadharno;
	@Column(name="dob")
	private String dob;
	@Column(name="raddressln1")
	private String raddressln1;
	@Column(name="raddressln2")
	private String raddressln2;
	@Column(name="landmark")
	private String landmark;
	@Column(name="state")
	private String state;
	@Column(name="city")
	private String city;
	@Column(name="pincode")
	private int pincode;
	@Column(name="praddressln1")
	private String praddressln1;
	@Column(name="praddressln2")
	private String praddressln2;
	@Column(name="plandmark")
	private String plandmark;
	@Column(name="pstate")
	private String pstate;
	@Column(name="pcity")
	private String pcity;
	@Column(name="ppincode")
	private int ppincode;
	@Column(name="occtype")
	private String occtype;
	@Column(name="sourceincome")
	private String sourceincome;
	@Column(name="annualincome")
	private int annualincome;
	
	
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public int getMobileno() {
		return mobileno;
	}
	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public int getAadharno() {
		return aadharno;
	}
	public void setAadharno(int aadharno) {
		this.aadharno = aadharno;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getRaddressln1() {
		return raddressln1;
	}
	public void setRaddressln1(String raddressln1) {
		this.raddressln1 = raddressln1;
	}
	public String getRaddressln2() {
		return raddressln2;
	}
	public void setRaddressln2(String raddressln2) {
		this.raddressln2 = raddressln2;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getPraddressln1() {
		return praddressln1;
	}
	public void setPraddressln1(String praddressln1) {
		this.praddressln1 = praddressln1;
	}
	public String getPraddressln2() {
		return praddressln2;
	}
	public void setPraddressln2(String praddressln2) {
		this.praddressln2 = praddressln2;
	}
	public String getPlandmark() {
		return plandmark;
	}
	public void setPlandmark(String plandmark) {
		this.plandmark = plandmark;
	}
	public String getPstate() {
		return pstate;
	}
	public void setPstate(String pstate) {
		this.pstate = pstate;
	}
	public String getPcity() {
		return pcity;
	}
	public void setPcity(String pcity) {
		this.pcity = pcity;
	}
	public int getPpincode() {
		return ppincode;
	}
	public void setPpincode(int ppincode) {
		this.ppincode = ppincode;
	}
	public String getOcctype() {
		return occtype;
	}
	public void setOcctype(String occtype) {
		this.occtype = occtype;
	}
	public String getSourceincome() {
		return sourceincome;
	}
	public void setSourceincome(String sourceincome) {
		this.sourceincome = sourceincome;
	}
	public int getAnnualincome() {
		return annualincome;
	}
	public void setAnnualincome(int annualincome) {
		this.annualincome = annualincome;
	}
	
	
}
