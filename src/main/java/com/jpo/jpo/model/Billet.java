package com.jpo.jpo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Table(name="billet")
@AllArgsConstructor
public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float prix;

    private String nomTicket;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    @JsonManagedReference
    private Commande commande;

    public Billet(){}

    public Billet(Float prix, String nomTicket) {
        this.prix = prix;
        this.nomTicket = nomTicket;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getNomTicket() {
        return nomTicket;
    }

    public void setNomTicket(String nomTicket) {
        this.nomTicket = nomTicket;
    }

    public Long getId() {
        return id;
    }
}
