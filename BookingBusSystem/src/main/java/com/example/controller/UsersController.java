package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Users;
import com.example.repository.UsersRepository;
import com.example.service.UsersService;

@CrossOrigin("*")
@RestController
public class UsersController {
	@Autowired
	private UsersService usersService;

	@Autowired
	private UsersRepository usersRepository;

	@GetMapping("/users")
	public Iterable<Users> index(Model model) {
		model.addAttribute("users", usersService.findAll());
		return usersService.findAll();
	}

	@PostMapping("/save")
	public Users save(@RequestBody Users user) {
		return usersService.save(user);

	}

	// Login Customer
	@GetMapping("/loginCustomer")
	public ResponseEntity<String> loginCustomer(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		return usersService.findByEmailAndPassword(email, password);

	}

	// Login Ticket Seller
	@GetMapping("/login-seller")
	public void loginTicketSeller(@RequestParam("email") String email, @RequestParam("password") String password) {
		if (email != null && password != null) {
			usersService.findByEmailAndPasswordTicketSeller(email, password);
		}
	}

	@GetMapping("/findbyEmail")
	public Users findUserbyEmail(@RequestParam("email") String email) {
		return usersRepository.findByEmail(email);
	}

}
