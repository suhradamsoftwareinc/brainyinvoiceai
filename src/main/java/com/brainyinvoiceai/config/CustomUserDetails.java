package com.brainyinvoiceai.config;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.brainyinvoiceai.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
 
public class CustomUserDetails implements UserDetails {
 

    private static final long serialVersionUID = 1L;
    private String username;
    private String fullName;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(String username, String fullName, String password,
        Collection<? extends GrantedAuthority> authorities) {
      this.username = username;
      this.fullName = fullName;
      this.password = password;
      this.authorities = authorities;
    }

    public static CustomUserDetails build(User user) {
      List<GrantedAuthority> authorities = user.getRoles().stream()
          .map(role -> new SimpleGrantedAuthority(role.getName()))
          .collect(Collectors.toList());

      return new CustomUserDetails(
          user.getEmail(), 
          user.getName(),
          user.getPassword(), 
          authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return authorities;
    }

    @Override
    public String getPassword() {
      return password;
    }

    @Override
    public String getUsername() {
      return username;
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

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      CustomUserDetails user = (CustomUserDetails) o;
      
      return Objects.equals(username, user.username);
    }

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
    
    
  }