package com.lti.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Column(name="balance", columnDefinition = "integer(1000000) default 10000")
	private int balance;
	@Column(name="transactionamt")
	private int transactionamt;
	@Column(name="availablebalance")
	private int availablebalance;
	@Column(name="toname")
	private String toname;
	@Temporal( TemporalType.DATE )
	private Date transactiondate;
	@Temporal( TemporalType.TIME)
	private Date transactiontime;
	
	
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
	public String getToname() {
		return toname;
	}
	public void setToname(String toname) {
		this.toname = toname;
	}
	public Date getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}
	public Date getTransactiontime() {
		return transactiontime;
	}
	public void setTransactiontime(Date transactiontime) {
		this.transactiontime = transactiontime;
	}
	public int getAvailablebalance() {
		return availablebalance;
	}
	public void setAvailablebalance(int availablebalance) {
		this.availablebalance = availablebalance;
	}
	
	
}
