package com.example.du.shop.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.du.shop.entity.SpringUser;

public interface UserRepository extends JpaRepository<SpringUser, String> {
	
	SpringUser findByUsername(String username);
}
