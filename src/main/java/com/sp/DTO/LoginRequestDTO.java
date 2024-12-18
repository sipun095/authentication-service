package com.sp.DTO;

import jakarta.validation.constraints.NotBlank;

public class LoginRequestDTO {
    //@NotBlank(message = "Username or Email cannot be empty")
    private String usernameOrEmail;

   // @NotBlank(message = "Password cannot be empty")
    private String password;

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
