package com.example.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.entity.Users;

public interface UsersService {
	Iterable<Users> findAll();

	Optional<Users> findOne(int id);

	Users save(Users users);

	void delete(int id);

	ResponseEntity<String> findByEmailAndPassword(String email, String password);

	public Users findByEmail(String email);
	
	Users findByEmailAndPasswordTicketSeller(String email, String password);

}
