package com.security.security_app.security;

import com.security.security_app.entities.Role;
import com.security.security_app.entities.User;
import com.security.security_app.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );

        Role role = user.getRole();

        Set<GrantedAuthority> authorities = new HashSet<>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
        authorities.add(authority);

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(), user.getPassword(), authorities
        );
    }
}
