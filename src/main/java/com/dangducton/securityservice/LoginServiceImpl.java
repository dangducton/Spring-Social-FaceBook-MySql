package com.dangducton.securityservice;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dangducton.model.UserInfo;
import com.dangducton.repository.UserRepository;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserInfo user = userRepository.findByEmailAndEnabled(email, true);
		if(user == null) {
			throw new UsernameNotFoundException("User not found for "+email);
		}
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" +user.getRole());
		UserDetails userDetails = new User(user.getEmail(),user.getPassword(),Arrays.asList(authority));
		return userDetails;
	}

}
