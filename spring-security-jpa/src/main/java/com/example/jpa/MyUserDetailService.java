package com.example.jpa;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.models.MyUserDetails;
import com.models.User;
import com.models.UserRepository;

public class MyUserDetailService implements UserDetailsService {

	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findByuserName(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found :" + username));
		return user.map(MyUserDetails::new).get();
	}

}
