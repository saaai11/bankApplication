package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.AccountBalance;

@Repository // creates a bean with repository value
public interface AccountBalanceRepository extends JpaRepository<AccountBalance, Integer> {

}
