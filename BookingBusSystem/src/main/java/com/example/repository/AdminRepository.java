package com.example.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Users;

public interface AdminRepository extends JpaRepository<Users, Integer> {

	Users findByEmailAndPassword(String email, String password);

	public Users findByEmail(String email);

	public List<Users> findByName(String name);

	public List<Users> findByNameContaining(String name);

	@Query("SELECT u FROM Users u where u.role.nameRole like %:name% ")
	List<Users> findUserByRole(@Param("name") String name);
	
}
