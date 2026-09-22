package com.m486.persistencia;

import java.util.List;

import com.m486.model.Persona;



public interface GestioPersona {

    List<Persona> obtenirTotesPersones();
    void guardaPersona(Persona persona);
}
