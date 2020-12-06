package com.example.demo.Model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transactions")
public class Transactions {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer transaction_id;
	
	@Column(name = "senderId")
	private Integer senderId;
	
	@Column(name = "beneficiaryId")
	private Integer beneficiaryId;
	
	@Column(name = "amount")
	private Integer amount;

	@Column(name = "credit")
	private Integer credit;
	
	@Column(name = "debit")
	private Integer debit;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "time")
	private Time time;
	
	
	@Column(name = "account_balance")
	private Integer accountBalance;
	
	
	
	
	 // getter method for getting time
	public Time getTime() {
		return time;
	}
	// setter method for setting time

	public void setTime(Time time) {
		this.time = time;
	}



	 // getter method for getting house no
	public Integer getAccountBalance() {
		return accountBalance;
	}
	// setter method for setting id

	public void setAccountBalance(Integer accountBalance) {
		this.accountBalance = accountBalance;
	}
	 // getter method for getting house no
	public Integer getTransactionId() {
		return transaction_id;
	}
	// setter method for setting id

	public void setTransactionId(Integer transactionId) {
		transaction_id = transactionId;
	}
	 // getter method for getting house no
	public Integer getSenderId() {
		return senderId;
	}
	// setter method for setting id

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	 // getter method for getting house no
	public Integer getBeneficiaryId() {
		return beneficiaryId;
	}
	// setter method for setting id

	public void setBeneficiaryId(Integer beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	 // getter method for getting amount
	public Integer getAmount() {
		return amount;
	}
	// setter method for setting amount

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	 // getter method for getting  credit
	public Integer getCredit() {
		return credit;
	}
	// setter method for setting credit

	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	 // getter method for getting debit
	public Integer getDebit() {
		return debit;
	}
	// setter method for setting debit

	public void setDebit(Integer debit) {
		this.debit = debit;
	}
	 // getter method for getting date
	public Date getDate() {
		return date;
	}
	// setter method for setting date

	public void setDate(Date date) {

		this.date = date;
		
	}
	
	
	
	
}
