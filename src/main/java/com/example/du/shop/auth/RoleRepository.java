package com.example.du.shop.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.du.shop.generated.Role;
import com.example.du.shop.generated.ShopUser;

public interface RoleRepository extends JpaRepository<Role, String> {
		

}
