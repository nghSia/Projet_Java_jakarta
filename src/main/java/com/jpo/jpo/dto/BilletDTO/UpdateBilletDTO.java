package com.jpo.jpo.dto.BilletDTO;


public class UpdateBilletDTO {
    private Long id;
    private Float prix;
    private String nom;

    public UpdateBilletDTO() {}

    public UpdateBilletDTO(Float prix, String nom) {
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

    public Long getId() {
        return id;
    }
}
