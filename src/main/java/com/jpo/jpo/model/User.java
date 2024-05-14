package com.jpo.jpo.model;

import com.jpo.jpo.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="user")
@Getter
@Setter
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private LocalDateTime deletedAt = null;

    public User(){}

    public User(String password, String email, UserRole role) {
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Long getId(){
        return id;
    }

    public String getPassword(){ return password; }
    public String getEmail(){ return email; }
    public UserRole getRole(){ return role; }
    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setRole(UserRole role){ this.role = role; }
    public void setPassword(String password){ this.password = password; }
    public void setEmail(String email){ this.email = email; }
    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
