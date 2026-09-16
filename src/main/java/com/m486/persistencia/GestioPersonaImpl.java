package com.m486.persistencia;

import com.m486.model.Persona;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GestioPersonaImpl implements GestioPersona {

    private File fitxer;
    public GestioPersonaImpl(File fitxer) {
        super();
        this.fitxer = fitxer;
    }

    public List<Persona> obtenirTotesPersones() {
        return List.of();
    }

    public void afegirPersona(Persona persona) {
        try (FileWriter fw = new FileWriter(fitxer, true)) {
            fw.write(persona.getNom()+" - "+Integer.toString(persona.getEdat())+":");
        } catch (IOException e) {
            throw new GestioPersonaException("Error guardant persona", e);
        }
    }
}
