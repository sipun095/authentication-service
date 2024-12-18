package com.sp.service.impl;

import com.sp.DTO.LoginRequestDTO;
import com.sp.DTO.UserRegistrationDTO;
import com.sp.entity.Role;
import com.sp.entity.User;
import com.sp.exception.UserNotFoundException;
import com.sp.repository.RoleRepository;
import com.sp.repository.UserRepository;
import com.sp.service.AuthenticationService;
import com.sp.utils.JWTUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtils jwtUtils;

    @Override
    @Transactional
    public String registerUser(UserRegistrationDTO registrationDTO){
        User user=new User();
        user.setUsername(registrationDTO.getUsername());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));

        User userDetails=userRepository.findByUsernameOrEmail(registrationDTO.getUsername(),registrationDTO.getEmail());
        if(userDetails==null){

        }
        // Assign role "USER" by default,
        Role userRole = roleRepository.findByName("USER");
        if (userRole == null) {
            userRole = new Role();
            userRole.setName("USER");
            roleRepository.save(userRole);
        }
        user.setRoles(Collections.singleton(userRole));
        userRepository.save(user);
        return "User registered successfully!";
    }
    @Override
    public String authenicateUser(LoginRequestDTO requestDTO){
        System.out.println("hsjjjs");
        User user=userRepository.findByUsernameOrEmail(requestDTO.getUsernameOrEmail(),requestDTO.getUsernameOrEmail());
        if (user != null && passwordEncoder.matches(requestDTO.getPassword(), user.getPassword())) {
            return jwtUtils.generateToken(user.getUsername());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }


}
