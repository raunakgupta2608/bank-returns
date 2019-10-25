package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction01")
public class Transaction 
{
	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO, generator ="transactionid" )
	@Column(name="tid")
	private int tid;
	@Column(name="refuserid")
	private int refuserid;
	@Column(name="refbeneficiaryaccno")
	private int refbeneficiaryaccno;
	@Column(name="balance")
	private int balance;
	@Column(name="transactionamt")
	private int transactionamt;
	@Column(name="toname")
	private int toname;
	@Column(name="transactiondate")
	private int transactiondate;
	@Column(name="transactiontime")
	private int transactiontime;
	@Column(name="transactiontype")
	private int transactiontype;
	@Column(name="tobankname")
	private int tobankname;
	@Column(name="tobankifsc")
	private int tobankifsc;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getRefuserid() {
		return refuserid;
	}
	public void setRefuserid(int refuserid) {
		this.refuserid = refuserid;
	}
	public int getRefbeneficiaryaccno() {
		return refbeneficiaryaccno;
	}
	public void setRefbeneficiaryaccno(int refbeneficiaryaccno) {
		this.refbeneficiaryaccno = refbeneficiaryaccno;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getTransactionamt() {
		return transactionamt;
	}
	public void setTransactionamt(int transactionamt) {
		this.transactionamt = transactionamt;
	}
	public int getToname() {
		return toname;
	}
	public void setToname(int toname) {
		this.toname = toname;
	}
	public int getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(int transactiondate) {
		this.transactiondate = transactiondate;
	}
	public int getTransactiontime() {
		return transactiontime;
	}
	public void setTransactiontime(int transactiontime) {
		this.transactiontime = transactiontime;
	}
	public int getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(int transactiontype) {
		this.transactiontype = transactiontype;
	}
	public int getTobankname() {
		return tobankname;
	}
	public void setTobankname(int tobankname) {
		this.tobankname = tobankname;
	}
	public int getTobankifsc() {
		return tobankifsc;
	}
	public void setTobankifsc(int tobankifsc) {
		this.tobankifsc = tobankifsc;
	}
	
	
	
	
	
}
