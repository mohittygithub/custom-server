package com.tyagi.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.tyagi.models.User;
import com.tyagi.repositories.UserRepository;

@Component
public class QueryService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers() {
		List<User> userList = userRepository.findAll();
		return userList;
		
	}
	
	public Map<String, String> getUserByUserId(String username) {
		Optional<User> optionalUser = userRepository.findByUsername(username);
		User user = optionalUser.get();
		Map<String, String> userMap = new HashMap<>();
		userMap.put("UserId", Integer.toString(user.getId()));
		userMap.put("FirstName", user.getFirstname());
		userMap.put("LastName", user.getLastname());
		userMap.put("Email", user.getUsername());
		return userMap;
	}
	
	public User saveNewUser(User request) {
		//System.out.println(request);
		String firstName = request.getFirstname();
		String lastName = request.getLastname();
		String username = request.getUsername();
		String password = request.getPassword();
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);
		System.out.println(encodedPassword);
		User user = new User();
		
		user.setFirstname(firstName);
		user.setLastname(lastName);
		user.setUsername(username);
		user.setPassword(encodedPassword);
		user.setActive(true);
		user.setRoles("ROLES_USER");
		
		User response  = userRepository.save(user);
		System.out.println(response);
		
		
		return response;
//		return null;
	}
}
