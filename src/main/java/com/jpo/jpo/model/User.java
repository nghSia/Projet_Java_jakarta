package com.jpo.jpo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpo.jpo.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Commande> commandes = new HashSet<>();

    public User(){}

    public User(String password, String email, UserRole role) {
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Long getId(){return id;}

    public String getPassword(){ return password; }
    public String getEmail(){ return email; }
    public UserRole getRole(){ return role; }
    public Set<Commande> getCommandes() {return commandes;}

    public void setRole(UserRole role){ this.role = role; }
    public void setPassword(String password){ this.password = password; }
    public void setEmail(String email){ this.email = email; }
    public void setCommandes(Set<Commande> commandes) {this.commandes = commandes;}
}
