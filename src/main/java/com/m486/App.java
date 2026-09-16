package com.m486;

import com.m486.model.Persona;
import com.m486.persistencia.GestioPersona;
import com.m486.persistencia.GestioPersonaImpl;

import java.io.File;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        GestioPersona gp = new GestioPersonaImpl(new File("./dades/persones"));
        gp.afegirPersona(new Persona("John", 23));
    }
}
