package com.m486.model;

public class Persona {
    private String nom;
    private int edat;

    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }

    public String getNom() {
        return this.nom;
    }

    public int getEdat() {
        return this.edat;
    }

    @Override
    public String toString() {
        return "nom='" + nom + '\'' +
                ", edat=" + edat;
    }
}
