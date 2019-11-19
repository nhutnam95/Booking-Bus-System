package com.example.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import com.example.entity.Users;
import com.example.service.AdminService;

@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
@RequestMapping("/admin")
@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/getUsers")
	public Page<Users> findAll(@RequestParam(defaultValue = "0") int page) {
		return adminService.findAll(PageRequest.of(page, 8));
	}
	
	@GetMapping("getUser/{id}")
	public Optional<Users> findOne(@PathVariable int id){
		return adminService.findOne(id);
	}
	
	@PutMapping("/updateUser")
	public Users update(@RequestBody Users user) {
		return adminService.save(user);
	}
	
	@PostMapping("/createUser")
	public Users create(@RequestBody Users user) {
		return adminService.save(user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public boolean delete(@PathVariable int id) {
		adminService.delete(id);
		return true;
	}
	
	@GetMapping("/loginAdmin")
	public ResponseEntity<String> loginAdmin(@RequestParam("email") String email,@RequestParam("password") String password) {
		
		return adminService.findByEmailAndPasswordAdmin(email, password);
	}
	
	@GetMapping("/findByEmail")
	public Users findByEmail(@RequestParam("email") String email) {
			return adminService.findByEmail(email);
	}
	
	/////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/findByName")
	public List<Users> findByName(@RequestParam("name") String name) {
			return adminService.findByName(name);
	}
	
	@GetMapping("/findByNameContaining")
	public List<Users> findByNameContaining(@RequestParam("name") String name) {
			return adminService.findByNameContaining(name);
	}
	
	@GetMapping("/findUserByRole")
	public List<Users> findUserByRole(@RequestParam("name") String name){
		return adminService.findUserByRole(name);
	}
}
