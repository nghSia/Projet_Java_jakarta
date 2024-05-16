package com.jpo.jpo.dto.UserDTO;


import com.jpo.jpo.enums.UserRole;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateUserDTO {
    @NotNull
    private Long id;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    private UserRole role;

    public CreateUserDTO(String password, String email, UserRole role) {
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPassword(){ return password; }
    public String getEmail(){ return email; }
    public UserRole getRole(){ return role; }
    public Long getId() {return id;}
}