package com.example.demo.Model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CustomerAccounts")
public class User {
	
	
	
	@Id
	@Column(name = "id", updatable = false, nullable = false)
    private Integer accountNo;
	
	
	@Column(name = "firstName")
	private String fName;
	@Column(name = "lastName")
	private String lName;
	@Column(name = "mobileNumber")
	private long mobileNumber;
	@Column(name = "email")
	private String email;
	@Column(name="title")
	private String title;
	@Column(name="nationality")
	private String nationality;
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "dateOfBirth")
	//@JsonFormat(pattern="")
	private String dateofBirth;
	@Column(name = "maritialStatus")
	private String maritialStatus;
	@Column(name="employmentStatus")
	private String employmentStatus;
	@Column(name="taxResidency")
	private String taxResidency;
	@Column(name="accountType")
	private String accountType;
	
	@Column(name="password")
	private String password;
	
	
	@Column(name = "sortCode")
	private String sortCode;
	
	
    @OneToOne( mappedBy = "user")
    @JsonIgnore
    @PrimaryKeyJoinColumn
	 private AccountBalance accountBalance;
    // getter method for getting title
	public String getTitle() {
		return title;
	}
	// setter method for setting title

	public void setTitle(String title) {
		this.title = title;
	}
	 // getter method for getting nationality
	public String getNationality() {
		return nationality;
	}
	// setter method for setting nationality

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	 // getter method for getting accountBalance no
	public AccountBalance getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(AccountBalance accountBalance) {
		this.accountBalance = accountBalance;
	}
	@OneToMany(mappedBy = "user1", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Address> address;


	
	
	 // getter method for getting gender no
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	 // getter method for getting StringofBirth no
	public String getDateofBirth() {
		return dateofBirth;
	}
	// setter method for setting StringofBirth

	public void setStringofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	 // getter method for getting maritialStatus 
	public String isMaritialStatus() {
		return maritialStatus;
	}
	// setter method for setting maritialStatus

	public void setMaritialStatus(String maritialStatus) {
		this.maritialStatus = maritialStatus;
	}
	 // getter method for getting employmentStatus
	public String getEmploymentStatus() {
		return employmentStatus;
	}
	// setter method for setting employmentStatus

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	 // getter method for getting taxResidency no
	public String getTaxResidency() {
		return taxResidency;
	}
	// setter method for setting taxResidency

	public void setTaxResidency(String taxResidency) {
		this.taxResidency = taxResidency;
	}
	 // getter method for getting accountType 
	public String getAccountType() {
		return accountType;
	}
	// setter method for accountType 

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	 // getter method for getting house no
	public String getPassword() {
		return password;
	}
	// setter method for setting id

	public void setPassword(String password) {
		this.password = password;
	}
	
	 // getter method for getting house no
	public Integer getAccountNo() {
		return accountNo;
	}
	// setter method for setting id

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}
	 // getter method for getting house no
	public String getSortCode() {
		return sortCode;
	}
	// setter method for setting id

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}
	
	
	 // getter method for getting house no
	public List<Address> getAddress() {
		return address;
	}
	// setter method for setting id

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	 // getter method for getting house fName
	public String getfName() {
		return fName;
	}
	// setter method for setting fName

	public void setfName(String fName) {
		this.fName = fName;
	}
	 // getter method for getting house no
	public String getlName() {
		return lName;
	}
	// setter method for setting id

	public void setlName(String lName) {
		this.lName = lName;
	}
	 // getter method for getting mobileNumber
	public long getMobileNumber() {
		return mobileNumber;
	}
	// setter method for setting mobileNumber

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	 // getter method for getting email
	public String getEmail() {
		return email;
	}
	// setter method for setting email

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
