package com.jpo.jpo.dto.UserDTO;

import com.jpo.jpo.enums.UserRole;
import jakarta.validation.constraints.NotNull;

public class UpdateUserDTO {
    @NotNull
    private Long id;
    private String password;
    private String email;
    private UserRole role;

    public UpdateUserDTO(String password, String email, UserRole role) {
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public void setEmail( String email) {
        this.email = email;
    }

    public void setPassword( String password) {
        this.password = password;
    }

    public void setRole( UserRole role) {
        this.role = role;
    }


    public String getPassword(){ return password; }
    public String getEmail(){ return email; }
    public UserRole getRole(){ return role; }
    public Long getId() { return id; }
}