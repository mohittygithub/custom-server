package com.tyagi.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyagi.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String username);

	

}
