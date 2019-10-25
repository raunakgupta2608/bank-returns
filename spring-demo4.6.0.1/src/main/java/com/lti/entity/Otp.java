package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="otp")
public class Otp 
{
	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO, generator ="otpid" )
/*	@SequenceGenerator ( name ="otpid", initialValue=10, sequenceName="otpid")
	@GeneratedValue ( strategy = GenerationType.SEQUENCE, generator ="otpid" )*/
	@Column(name="otpid")
	private int otpid;
	@Column(name="accno")
	private int accno;
	@Column(name="otp")
	private int otp;
	public int getOtpid() {
		return otpid;
	}
	public void setOtpid(int otpid) {
		this.otpid = otpid;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
}
