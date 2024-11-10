package com.alek0m0m.aicookbookbackend.dto;

import com.Alek0m0m.library.jpa.BaseEntityDTO;
import com.alek0m0m.aicookbookbackend.model.User;

public class UserDTO extends BaseEntityDTO<User> {

    private String username;
    private String password;
    private String email;
    private String role;

    @Override
    public User toEntity() {
        User user = new User();
        user.setId(getId());
        user.setUsername(getUsername());
        user.setPassword(getPassword());
        user.setEmail(getEmail());
        user.setRole(getRole());
        return user;
    }


    // getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // toString
    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", email=" + email + ", role=" + role + "]";
    }

}
