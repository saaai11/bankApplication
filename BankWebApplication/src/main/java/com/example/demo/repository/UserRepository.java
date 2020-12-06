package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.User;

@Repository // creates a bean with repository value
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmail(String email);
	
}
