package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ApiService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class CustomerApi {
	
	
	@Autowired
	private ApiService apiService;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	 @GetMapping()                                             // get mapping annotation
	  public List<User> getAccounts() {
	  return apiService.getAccountss();
	   }
	
	
	  // fetch an user for by taking userid
	 
		/*
		 * @GetMapping("/") public void login()) {
		 * 
		 * 
		 * 
		 * boolean isPasswordMatch = pwdEncoder.matches(password, encodedPassword);
		 * System.out.println("Password : " + password + "   isPasswordMatch    : " +
		 * isPasswordMatch); }
		 */
	 
	 @PostMapping(value = "/login")
	 public ResponseEntity<String> login(@RequestBody User user) {
		 
		 
		 User user2 = this.userRepository.findByEmail(user.getEmail());
		 
		if(user2==null) {
			return new ResponseEntity<String>("Invalid email ID,check your email", HttpStatus.BAD_REQUEST);

		}
		
		 boolean isPasswordMatch = pwdEncoder.matches( user.getPassword(),  user2.getPassword());
		 System.out.println("Password : " + user.getPassword() + "   isPasswordMatch    : " + isPasswordMatch); 
		 
		 
		 if(isPasswordMatch)
				return new ResponseEntity<String>("successfully logged", HttpStatus.OK);
		 else 
				return new ResponseEntity<String>("Authentication failed", HttpStatus.FORBIDDEN);


		 
	 }
			
			  @GetMapping("user/{id}")                                             // get mapping annotation
			  public User getAccount(@PathVariable (value="id") Integer id) {
			  return apiService.getUserAccount(id);
			   }
			 
	 
				//Create an user
			  
	 @PostMapping( value = "savedetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	 public int postAccount(@RequestBody User user ) {
		    
		 String password =  user.getPassword();
		 String encryptPassword = pwdEncoder.encode(password);
		 
		 user.setPassword(encryptPassword);
		 
		 
		System.out.println( user.getDateofBirth()   + "  date of birth");
		 
			return apiService.saveUserData(user); 
	       }

	
	//update user details with userId
	
	@PutMapping("userdetails/{id}")
	public ResponseEntity<String> updateAccount(@RequestBody User user, @PathVariable (value = "id") Integer userId) {
		 
		return  apiService.updateUserAccount(userId, user);
		
	}
	
	//delete user by taking userid as a primary key

	@DeleteMapping("userdetails/{id}")
	public ResponseEntity<User> deleteAccount(@PathVariable ("id") Integer userId){
		
		return apiService.deleteUserAccount(userId);
		
				}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
