package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userRepository.save(user);
	}
}
