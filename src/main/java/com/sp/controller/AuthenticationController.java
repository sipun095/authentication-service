package com.sp.controller;

import com.sp.DTO.LoginRequestDTO;
import com.sp.DTO.UserRegistrationDTO;
import com.sp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
   // @Autowired// instead of field injection prefer constructor inject for better to write code testing and it's fast bcz it not using any reflection aslo to avoid circular dependency
   //if single field is there to inject spring boot automatically will inject but if more field use lombok
    AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @PostMapping("/register")
    public String register(@RequestBody UserRegistrationDTO userRegistrationDTO){
        System.out.println(userRegistrationDTO);
      return   authenticationService.registerUser(userRegistrationDTO);
    }
    @PostMapping("/login")
    public String authenicate(@RequestBody LoginRequestDTO loginRequestDTO){
        return authenticationService.authenicateUser(loginRequestDTO);
    }


}
