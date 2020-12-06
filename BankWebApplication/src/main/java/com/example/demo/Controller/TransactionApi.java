package com.example.demo.Controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.AccountBalance;
import com.example.demo.Model.Transactions;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AccountBalanceRepository;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.ApiService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/transactions")
public class TransactionApi {

	@Autowired
	public TransactionRepository transactionRepository;
	
	@Autowired
	public AccountBalanceRepository accountBalanceRepository;
	
	ApiService apiService = new ApiService();
	
	 Transactions transactions = new Transactions();
	 LocalDate localDateTime = LocalDate.now();
	 LocalTime localTime = LocalTime.now();

	 // a rest api which fetches all the transactions in the table

	 @GetMapping("/accounts")
	 public List<Transactions> getAllTransactionsAdmin(){
		 return this.transactionRepository.findAll();
		 }
	 
	 // a rest api which fetches all the transactions for a particular user

	 
		
		  @GetMapping("account/{accountNo}")
		  public List<Transactions> getTransactionUser(@PathVariable(value="accountNo") Integer senderId,@PathVariable(value="accountNo") Integer beneficiaryId) 
		  { 
			  return this.transactionRepository.findBySenderIdEqualsOrBeneficiaryIdEquals( senderId, beneficiaryId);
			  }
		 
	
	
	@PostMapping("saveTransaction")
	public String postTransaction(@RequestBody Transactions transaction) {
		
		
		Date date = Date.valueOf(LocalDate.now());
		
		Time time = Time.valueOf(localTime);
		
		System.out.println(date + " localdate");

		
		System.out.println(time + " localTime");


		transaction.setDate(date);
		transaction.setTime(time);
		
		
		
	    Optional<AccountBalance> balance = this.accountBalanceRepository.findById(transaction.getSenderId());
	    
	    int trueBalance = 0;
	    if(balance.isPresent()) {
	    	 trueBalance = (int) balance.get().getBalance();
	    }
			
	    System.out.println( trueBalance + "     true balance");
	    
	    int credit = (int)transaction.getAmount();
	    
	    //check if the customer can send the amount to his beneficiary
	    
	    if(trueBalance<credit) {
			return "Your account contains insufficient funds to process this transaction";			
	    }
	    else {
		
				

		
		
		int finalBalance = trueBalance-credit; // calculating the final balance
		
		if(!accountBalanceRepository.findById(transaction.getSenderId()).isPresent()) {
			return  "Invalid Sender, please do register to continue";

		}
		
		if(!accountBalanceRepository.findById(transaction.getBeneficiaryId()).isPresent()) {
			return "Invalid AccountId, the Account number doesn't exist";

		}
		
		AccountBalance senderBalance =	accountBalanceRepository.findById(transaction.getSenderId()).orElseThrow(() -> new ResourceNotFoundException("Account no is not found") );;
		
		senderBalance.setBalance(finalBalance); // updating the account balance table with the new balance after the successful transaction
		
		this.accountBalanceRepository.save(senderBalance);
		
		
		transaction.setAccountBalance(finalBalance);

		
	
		AccountBalance beneficiaryBalance =	accountBalanceRepository.findById(transaction.getBeneficiaryId()).orElseThrow(() -> new ResourceNotFoundException("Account no is not found") );;

		beneficiaryBalance.setBalance(credit+(beneficiaryBalance.getBalance())); // updating the beneficiary balance with the new added balance
		
		this.accountBalanceRepository.save(beneficiaryBalance);

		
		System.out.println( "True Balance : "+ trueBalance+   "    finalBalance  : "+finalBalance + "   "+ "beneficiaryBalance : "+ (credit+(beneficiaryBalance.getBalance())));
		
		this.transactionRepository.save(transaction);		

		
		return "successfully completed the transaction" ;

	    }

		
	}
	
	// a transaction can only be saved and cannot be deleted or updated 
	
}
