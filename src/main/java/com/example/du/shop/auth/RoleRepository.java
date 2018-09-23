package com.example.du.shop.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.du.shop.generated.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
	
	Role findByRlName(String rlName); 

}
