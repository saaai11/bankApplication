package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.AccountBalance;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AccountBalanceRepository;
import com.example.demo.service.ApiService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/api/Accountbalance")
public class AccountBalanceApi {

	// cretae a bean for the accountbalancerepository 

	@Autowired
	AccountBalanceRepository accountBalanceRepository;
	
	// cretae a bean for the api service class
	@Autowired
	ApiService apiService;
	
	
	@GetMapping("/{accountNo}")
	public ResponseEntity<String> getAccountBalance(@PathVariable (value = "accountNo") Integer accountNo) { 
		
	return 	apiService.getBalance(accountNo);
		
	}
	
	@PutMapping("/update/{accountNo}")
	public  ResponseEntity<String> updateAccountBalance(@RequestBody AccountBalance accountBalance,  @PathVariable (value = "accountNo")   Integer accountNo){
		
	AccountBalance existingAccountBalance =	this.accountBalanceRepository.findById(accountNo).orElseThrow(() -> new ResourceNotFoundException("Account is not found with " + accountNo) );
	
	Integer initialBalance = existingAccountBalance.getBalance();
	
	Integer enteredBalance = accountBalance.getBalance();
	
	Integer finalBalance;
	


	
	if(enteredBalance!=null) {
	 finalBalance = initialBalance + enteredBalance ;
	}
	else {
		finalBalance = initialBalance;
	}
	
	existingAccountBalance.setBalance(finalBalance);
	
	accountBalanceRepository.save(existingAccountBalance);
	
	System.out.println("saved successfully   " + finalBalance);
	
	return new ResponseEntity<String>("successfully updated", HttpStatus.OK);
		
	}
	
}
