package com.tyagi.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tyagi.models.User;
import com.tyagi.repositories.UserRepository;
import com.tyagi.services.QueryService;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	QueryService queryService;
	
	
	@GetMapping("/me")
	public Map<String, String> getUserByUserId(Principal principal) {
		return queryService.getUserByUserId(principal.getName());
	}
		
	
	@PostMapping("/create/admin")
	public User createUser(@RequestBody User request) throws JsonParseException, JsonMappingException, IOException {
		return queryService.saveNewUser(request);
	}
}
