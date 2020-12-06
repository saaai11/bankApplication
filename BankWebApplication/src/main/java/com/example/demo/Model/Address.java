package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * @author saiprathap reddy
 *
 */
@Entity //create an entity
@Table(name = "UserAddress") //creates a table with table name with UserAddress as the name
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // generates the value of the id automatically with primary id
	private Integer id;
	@Column(name ="houseNo") //
	private int houseNo;   
	@Column(name ="streetName")
	private String streetName;
	@Column(name ="County")
	private String county;
	@Column(name ="postCode")
	private String postCode;
	
	@ManyToOne
	@JoinColumn(name = "accountNo",insertable = true, updatable = false)
	@JsonBackReference
	private User user1;
	
	
	public int getHouseNo() {  // getter method for getting house no
		return houseNo;
	}
	// setter method for setting house no

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	
	 // getter method for getting streetName
	public String getStreetName() {
		return streetName;
	}
	// setter method for setting streetName

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	 // getter method for getting county
	public String getCounty() {
		return county;
	}
	// setter method for setting county

	public void setCounty(String county) {
		this.county = county;
	}
	 // getter method for getting postCode
	public String getPostCode() {
		return postCode;
	}
	// setter method for setting postCode

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	 // getter method for getting user1
	public User getUser1() {
		return user1;
	}
	// setter method for setting user1

	public void setUser1(User user1) {
		this.user1 = user1;
	}
	

}
