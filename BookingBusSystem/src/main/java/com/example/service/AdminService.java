package com.example.service;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import com.example.entity.Users;

public interface AdminService {
	
	Page<Users> findAll(Pageable pageable);
	Optional<Users> findOne(int id);
	
	Users save(Users user);
	void delete(int id);
	
	ResponseEntity<String> findByEmailAndPasswordAdmin(String email, String password);
	public Users findByEmail(String email);
	List<Users> findByName(String name);
	List<Users> findByNameContaining(String name);
	List<Users> findUserByRole(String name);
	
}
