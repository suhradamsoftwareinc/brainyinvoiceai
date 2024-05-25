package com.brainyinvoiceai.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.brainyinvoiceai.entity.Role;
import com.brainyinvoiceai.entity.User;
import com.brainyinvoiceai.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	
    	System.out.println("Minesh here");
        User user = userRepository.findByEmail(email);

        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

        /* this is just a sample , you must implement bringing data from repository then prefix every string with ROLE_ */
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
      
        
        if (user != null) {
        	return CustomUserDetails.build(user);
        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles) {
        Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return mapRoles;
    }
}