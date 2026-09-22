package com.m486;

import com.m486.model.Persona;
import com.m486.persistencia.GestioPersona;
import com.m486.persistencia.GestioPersonaImpl;

import java.io.File;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        GestioPersona gp = new GestioPersonaImpl(new File("./dades/persones.txt"));

        gp.guardaPersona(new Persona("Adam", 99));

        List<Persona> personas = gp.obtenirTotesPersones();


        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
}
