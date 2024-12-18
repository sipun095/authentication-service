package com.sp.service;

import com.sp.DTO.LoginRequestDTO;
import com.sp.DTO.UserDTO;
import com.sp.DTO.UserRegistrationDTO;

public interface AuthenticationService {
    String registerUser(UserRegistrationDTO registrationDTO);
    String authenicateUser(LoginRequestDTO requestDTO);
}
