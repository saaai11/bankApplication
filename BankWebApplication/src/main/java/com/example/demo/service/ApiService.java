package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.AccountBalance;
import com.example.demo.Model.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AccountBalanceRepository;
import com.example.demo.repository.UserRepository;

@Service
public class ApiService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountBalanceRepository accountBalanceRepository;
	
	public List<User> getAccountss() {
		return this.userRepository.findAll();
	}
	
	public User getUserAccount(Integer id) {
		return this.userRepository.findById(id).orElseThrow(()-> new
				  ResourceNotFoundException("user not found : "+ id));
				 
	}
	
	
	public ResponseEntity<String> updateUserAccount(Integer userId,User user) {
		
		if( !this.userRepository.findById(userId).isPresent()) {
			return new ResponseEntity<String>("Not a valid account number", HttpStatus.UNAUTHORIZED);

		}
		User existingUser = this.userRepository.findById(userId).
				orElseThrow(() -> new ResourceNotFoundException("User is not found with " + userId) );
		existingUser.setlName(user.getlName());
		
		existingUser.setfName(user.getfName());
		
		this.userRepository.save(existingUser);

		return new ResponseEntity<String>("Successfullu updated your details", HttpStatus.OK);
 
	}
	
	public ResponseEntity<User> deleteUserAccount(Integer userId){
User existingUser = this.userRepository.findById(userId).orElseThrow( () -> new ResourceNotFoundException("user with userid is not found " + userId)  );
		
		this.userRepository.delete(existingUser);
		return ResponseEntity.ok().build();
	}
	
	public int saveUserData(User user) {
		
		AccountBalance accountBalance = new AccountBalance();
		
		boolean result = false;
		
		Long min = (long)1000000;
		Long max = (long)9999999;

 
		String sortCode = "00-40-04";
		
	      Integer accountNumber = (int)(Math.random() * (max - min + 1) + min);
	      

		try {
			
			while( !userRepository.findById(accountNumber).isEmpty()) {
		    	  accountNumber =  (int)(Math.random() * (max - min + 1) + min);  
		      }

			
			user.setAccountNo(accountNumber);
			user.setSortCode(sortCode);
			
			accountBalance.setBalance(0);
			accountBalance.setSortCode("04-00-40");
			accountBalance.setOverDraft(100);
		
			accountBalance.setId(accountNumber);
			userRepository.save(user);
			
			
			accountBalanceRepository.save(accountBalance);
			result = true;

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return accountNumber;

	}
	
	// method for fetching the balance of the customer using account no
	
	public ResponseEntity<String> getBalance(Integer accountNo){
		
		Optional<AccountBalance> findById = this.accountBalanceRepository.findById(accountNo);
		if(findById.isPresent()) {
			return new ResponseEntity<String>(""+findById.get().getBalance(), HttpStatus.OK);
		}
		else 
			return new ResponseEntity<String>("Not a valid account number", HttpStatus.UNAUTHORIZED);
	}
	
	

}
