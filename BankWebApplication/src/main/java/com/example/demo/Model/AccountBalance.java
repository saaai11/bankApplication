package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account_balance_table")
public class AccountBalance {

	
	  @Id
	  @Column(name = "accountNo") 
	  private Integer id;
	  
		  @OneToOne
		  @JoinColumn(name = "accountNo", insertable = true, updatable = false)
		  private User user;
		 
	 
		
		  public User getUser() { return user; }
		  public void setUser(User user) {
		  this.user = user; }
		 
	@Column(name = "sortCode")
	private String sortCode;
	@Column(name = "balance", columnDefinition = "Integer default 100")
	private Integer balance;
	
	@Column(name = "Overdraft")
	private Integer overDraft;
	
	 public Integer getOverDraft() {
		return overDraft;
	}
	public void setOverDraft(Integer overDraft) {
		this.overDraft = overDraft;
	}
	// getter method for getting id
	public Integer getId() {
		return id;
	}
	// setter method for setting id
	public void setId(Integer id) {
		this.id = id;
	}
	 // getter method for getting sortcode
	public String getSortCode() {
		return sortCode;
	}	
	// setter method for setting id

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}
	 // getter method for getting balance
	public Integer getBalance() {
		return balance;
	}
	// setter method for setting id

	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	
	
	
}
