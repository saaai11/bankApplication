package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Address;

@Repository  // creates a bean with repository value
public interface AddressRepository extends JpaRepository<Address, Long>{

}
