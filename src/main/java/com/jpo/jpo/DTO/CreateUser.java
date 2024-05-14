package com.jpo.jpo.DTO;

import com.jpo.jpo.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateUser {
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotNull
    private UserRole role;

    public CreateUser(String password, String email, UserRole role) {
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getPassword(){ return password; }
    public String getEmail(){ return email; }
    public UserRole getRole(){ return role; }
}

