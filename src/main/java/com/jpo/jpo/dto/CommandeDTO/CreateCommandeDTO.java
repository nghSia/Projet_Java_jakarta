package com.jpo.jpo.dto.CommandeDTO;


import com.jpo.jpo.enums.TypeCommande;
import com.jpo.jpo.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CreateCommandeDTO {

//    @NotNull
//    private Long id;

    private LocalDateTime dateCmd = LocalDateTime.now();

    @NotNull
    private Float montant;

    @NotNull
    private TypeCommande type;

    private User user;

    public CreateCommandeDTO(){}

    public CreateCommandeDTO(Float montant,TypeCommande type) {
        this.montant = montant;
        this.type = type;
    }

    public LocalDateTime getDateCmd() {
        return dateCmd;
    }

    public void setDateCmd(LocalDateTime dateCmd) {
        this.dateCmd = dateCmd;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public TypeCommande getType() {
        return type;
    }

    public void setType(TypeCommande type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public Long getId() {
//        return id;
//    }
}

