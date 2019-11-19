package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.Users;
import com.example.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private JwtService jwtService;

	@Override
	public Iterable<Users> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<Users> findOne(int id) {
		return userRepository.findById(id);
	}

	@Override
	public Users save(Users users) {

		users.setPassword(passwordEncoder.encode(users.getPassword()));
		return userRepository.save(users);
	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public ResponseEntity<String> findByEmailAndPassword(String email, String password) {

		Users users = userRepository.findByEmail(email);
		if (users != null) {
			if (passwordEncoder.matches(password, users.getPassword())) {
				String token = jwtService.generateTokenLogin(email);
				return new ResponseEntity<>(token, HttpStatus.OK);
			}

		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Override
	public Users findByEmail(String email) {

		return userRepository.findByEmail(email);
	}

	@Override
	public Users findByEmailAndPasswordTicketSeller(String email, String password) {
		Users user = userRepository.findByEmail(email);

		if (user != null) {
			if (passwordEncoder.matches(password, user.getPassword())
					&& (user.getRole().getIdrole() == 2)) {
				jwtService.generateTokenLogin(email);

				return user;
			}
		}

		return null;

	}
}
