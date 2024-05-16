package com.jpo.jpo.dto.BilletDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateBilletDTO {
//    @NotNull
//    private Long id;
    @NotNull
    private Float prix;
    @NotBlank
    private String nom;

    public CreateBilletDTO() {}

    public CreateBilletDTO(Float prix, String nom) {
        this.prix = prix;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom) {
        this.nom = nom;
    }

    public  Float getPrix() {
        return prix;
    }

    public void setPrix( Float prix) {
        this.prix = prix;
    }

//    public Long getId() {
//        return id;
//    }
}
