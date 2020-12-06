package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Transactions;


@Repository // creates a bean with repository value
public interface TransactionRepository extends JpaRepository<Transactions, Integer>{

	//a method to be used in the transactions api for getting the list of transactions using the account number
public List<Transactions> findBySenderIdEqualsOrBeneficiaryIdEquals(Integer senderId, Integer beneficiaryId); 
	
	
}

