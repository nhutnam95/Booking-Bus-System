package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	   Users findByEmailAndPassword(String email, String password);
	   
	   public Users findByEmail(String email);
	   
	   @Query("SELECT u FROM Users u WHERE u.email = :email AND u.password = :password AND u.role.idrole = 2 AND u.role.idrole = 3")
	   Users findByEmailAndPasswordTicketSeller(@Param("email") String email, @Param("password") String password);
}
