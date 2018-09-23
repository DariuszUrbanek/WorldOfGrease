package com.example.du.shop.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.du.shop.generated.ShopUser;

public interface UserRepository extends JpaRepository<ShopUser, String> {
	
	Optional<ShopUser> findBySuLogin(String suLogin);

	boolean existsBySuLogin(String username);
}
