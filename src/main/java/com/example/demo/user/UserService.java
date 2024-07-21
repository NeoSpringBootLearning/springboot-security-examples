package com.example.demo.user;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findByEmail(username);
		if(user.isEmpty()) {
			throw new UsernameNotFoundException("User Not Exits " +username);
		}else {
			var newUser = user.get();
			return org.springframework.security.core.userdetails.User.builder()
						.username(newUser.getEmail())
						.password(newUser.getPassword())
						.roles(newUser.getRoles())
						.build();
		      
		}
	}

	

}
