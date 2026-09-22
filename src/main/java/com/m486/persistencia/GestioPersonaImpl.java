package com.m486.persistencia;

import com.m486.model.Persona;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestioPersonaImpl implements GestioPersona {

    private File fitxer;
    public GestioPersonaImpl(File fitxer) {
        super();
        this.fitxer = fitxer;
    }

    public List<Persona> obtenirTotesPersones() {
        List<Persona> persones = new ArrayList<>();

        try(FileReader reader = new FileReader(fitxer)){
            StringBuilder sBuilder = new StringBuilder();
            int caracter;
            while ((caracter = reader.read()) != -1){
                if (caracter == ':'){
                    afegirPersones(persones, sBuilder.toString());
                    sBuilder.setLength(0);
                } else {
                    sBuilder.append((char) caracter);
                }
            }
        } catch (IOException e) {
            throw new GestioPersonaException("Error llegint persones des de el fitxer", e);
        }
        return persones;
    }

    private void afegirPersones(List<Persona> persones, String string) {
        String[] dades = string.split("-");
        String nom = dades[0];
        int edat = Integer.parseInt(dades[1]);
        persones.add(new Persona(nom, edat));
    }

    public void guardaPersona(Persona persona) {
        try (FileWriter fw = new FileWriter(fitxer, true)) {
            fw.write(persona.getNom() + "-" + persona.getEdat() +":");
        } catch (IOException e) {
            throw new GestioPersonaException("Error guardant persona a fitxer", e);
        }
    }
}
