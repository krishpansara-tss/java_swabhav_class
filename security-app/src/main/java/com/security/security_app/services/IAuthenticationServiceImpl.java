package com.security.security_app.services;

import com.security.security_app.config.SecurityConfig;
import com.security.security_app.dtos.LoginDto;
import com.security.security_app.dtos.RegistrationDto;
import com.security.security_app.dtos.UserResponseDto;
import com.security.security_app.entities.Role;
import com.security.security_app.entities.User;
import com.security.security_app.exceptions.UserApiException;
import com.security.security_app.repositories.RoleRepository;
import com.security.security_app.repositories.UserRepository;
import com.security.security_app.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IAuthenticationServiceImpl implements IAuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    private  final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto register(RegistrationDto dto) {
        boolean isUserExists = userRepository.existsByUserName(dto.getUserName());
        if(isUserExists){
            throw new UserApiException(HttpStatus.ALREADY_REPORTED, "User already exists");
        }

        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        Role userRole = roleRepository.findByName(dto.getRole()).orElseThrow(
                () -> new UserApiException(HttpStatus.BAD_REQUEST, "Role don't exists")
        );

        userRole.getUsers().add(user);
        user.setRole(userRole);

        User added_user = userRepository.save(user);
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setUsername(added_user.getUserName());
        responseDto.setUserId(added_user.getUserId());


        return responseDto;
    }

    @Override
    public String login (LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getUserName(), loginDto.getPassword())
            );

           // SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = tokenProvider.generateToken (authentication);
            return token;
        } catch (BadCredentialsException e) {
            throw new UserApiException(HttpStatus.NOT_FOUND, "Username or Password is incorrect");
        }
    }
}