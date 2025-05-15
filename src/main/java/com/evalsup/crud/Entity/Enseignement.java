package com.evalsup.crud.Entity;

import jakarta.persistence.*;

@Entity
public class Enseignement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sous_module_id")
    private SousModule sousModule;

    // No-arg constructor
    public Enseignement() {
    }

    // All-args constructor
    public Enseignement(Long id, Professeur professeur, SousModule sousModule) {
        this.id = id;
        this.professeur = professeur;
        this.sousModule = sousModule;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public SousModule getSousModule() {
        return sousModule;
    }

    public void setSousModule(SousModule sousModule) {
        this.sousModule = sousModule;
    }

    // toString method
    @Override
    public String toString() {
        return "Enseignement{" +
                "id=" + id +
                ", professeur=" + professeur +
                ", sousModule=" + sousModule +
                '}';
    }
}
