
package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.Controller.CustomerApi;
import com.example.demo.Model.Address;
import com.example.demo.Model.User;
import com.example.demo.service.ApiService;

@RunWith(SpringRunner.class)

@WebMvcTest(value = CustomerApi.class)
public class CustomerApiTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ApiService apiService;

	@Test
	public void getAllUsers() throws Exception {

		User user = new User();
		Address address = new Address();

		Date dob = new Date(11 - 05 - 1996);
		user.setfName("sai prathap");
		user.setlName("vennam");
		user.setAccountNo(8765433);
		user.setEmail("prathapsaireddy@yahoo.com");
		user.setEmploymentStatus("full time");
		user.setGender("male");
		user.setAccountType("student");
		user.setMaritialStatus("Single");
		user.setMobileNumber(91331360);
		user.setNationality("Uk");
		user.setSortCode("11-03-06");
		user.setPassword("saichina");
		user.setTaxResidency("Uk");
		user.setTitle("Mr");

		address.setCounty("London");
		address.setHouseNo(4);
		address.setPostCode("e151ls");
		address.setStreetName("Hughan Road");
		address.setUser1(user);

		List<Address> listAddress = new ArrayList<Address>();

		
			listAddress.add(address);
	

		user.setAddress(listAddress);

		assertEquals(user, user);

	//	System.out.println(apiService.getUserAccount(8765433) + "    apiservice");

		mvc.perform(get("/api/users/user/8765433").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

}
