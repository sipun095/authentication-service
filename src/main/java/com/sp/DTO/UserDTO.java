package com.sp.DTO;

public class UserDTO {
    private String username;
    private String emails;
    private String password;
    private String role;

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //    public UserDetailDTO(String username, String emails, String role) {
//        this.username = username;
//        this.emails = emails;
//        this.role = role;
//    }
}
