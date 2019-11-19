package com.example.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.entity.Users;
import com.example.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	@Override
	public Page<Users> findAll(Pageable pageable) {
		return adminRepository.findAll(pageable);
	}

	@Override
	public Optional<Users> findOne(int id) {
		return adminRepository.findById(id);
	}

	@Override
	public Users save(Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return adminRepository.save(user);
	}

	@Override
	public void delete(int id) {
		adminRepository.deleteById(id);
	}

	@Override
	public ResponseEntity<String> findByEmailAndPasswordAdmin(String email, String password) {
		Users users = adminRepository.findByEmail(email);
		if (users !=null)
		{	
			//System.out.println(passwordEncoder.encode("123"));
			System.out.println("yyyyyy");
			System.out.println(passwordEncoder.matches(password, users.getPassword()));
			if(passwordEncoder.matches(password, users.getPassword())) {
				System.out.println("adasada");
				String token = jwtService.generateTokenLogin(email);
				return new ResponseEntity<>(token,HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}

	@Override
	public Users findByEmail(String email) {
		return adminRepository.findByEmail(email);
	}

	@Override
	public List<Users> findByName(String name) {
		return adminRepository.findByName(name);
	}

	@Override
	public List<Users> findByNameContaining(String name) {
		return adminRepository.findByNameContaining(name);
	}

	@Override
	public List<Users> findUserByRole(String name) {
		return adminRepository.findUserByRole(name);
	}

}
