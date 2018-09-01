package com.example.du.shop.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.du.shop.entity.SpringRole;

public interface RoleRepository extends JpaRepository<SpringRole, String> {
	

}
