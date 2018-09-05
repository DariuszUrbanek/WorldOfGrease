package com.example.du.shop.auth;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.du.shop.generated.ShopUser;

public class UserPrincipal implements UserDetails {
	private static final long serialVersionUID = -2971393542317040515L;

	private ShopUser user;

	@Autowired
	UserRepository userRepository;

	public UserPrincipal(ShopUser user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRlName().toUpperCase())).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return user.getSuPassword();
	}

	@Override
	public String getUsername() {
		return user.getSuLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

