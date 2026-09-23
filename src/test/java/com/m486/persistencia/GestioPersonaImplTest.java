package com.m486.persistencia;

import com.m486.model.Persona;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GestioPersonaImplTest {

    @TempDir
    Path directoriTemporal;

    private File fitxer;
    private GestioPersona gestio;

    @BeforeEach
    void setUp() {
        fitxer = directoriTemporal.resolve("persones.txt").toFile();
        gestio = new GestioPersonaImpl(fitxer);
    }

    @Test
    void testAfegirUnaPersona() {
        // Arrange
        Persona persona = new Persona("Maria", 25);

        // Act
        gestio.guardaPersona(persona);

        // Assert
        List<Persona> persones = gestio.obtenirTotesPersones();


        assertEquals(1, persones.size());
        assertEquals("Maria", persones.get(0).getNom());
        assertEquals(25, persones.get(0).getEdat());
    }

    //afegir test d'afegir una persona amb dades incorrectes

    @Test
    void testAfegirDuesPersones() {
        // Arrange
        Persona persona1 = new Persona("Maria", 25);
        Persona persona2 = new Persona("Joan", 30);

        // Act
        gestio.guardaPersona(persona1);
        gestio.guardaPersona(persona2);

        // Assert
        List<Persona> persones = gestio.obtenirTotesPersones();

        assertEquals(2, persones.size());

        assertEquals("Maria", persones.get(0).getNom());
        assertEquals(25, persones.get(0).getEdat());

        assertEquals("Joan", persones.get(1).getNom());
        assertEquals(30, persones.get(1).getEdat());
    }

    @Test
    void testObtenirTotsFitxerBuit() throws IOException {

        //Arrange
        fitxer.createNewFile();
        // Act
        List<Persona> persones = gestio.obtenirTotesPersones();

        // Assert
        assertEquals(0, persones.size());
    }


    @Test
    void testFitxerInexistentQuanObtenimTots() throws IOException{

        // Arrange

        Path directori = directoriTemporal.resolve("directori");
        Files.createDirectory(directori);
        GestioPersonaImpl gestioError = new GestioPersonaImpl(directori.toFile());

        // Act + Assert
        GestioPersonaException excepcio = assertThrows( GestioPersonaException.class, () -> gestioError.obtenirTotesPersones() );
        assertEquals( "Error llegint persones des de el fitxer", excepcio.getMessage() );
    }

    //Afegir els tests necessaris per a testejar el mètode
    // de cerca per nom

    @Test
    void testCercaPersonesPerNomSiEstaEnFitxer(){
        Persona persona = new Persona("Juan", 25);

        String nom = "Juan";

        gestio.guardaPersona(persona);

        List<Persona> personesCercades = gestio.cercaPerNom(nom);

        assertEquals(1, personesCercades.size());
    }

    @Test
    void testNotrobaPersonesCercadesPerNomSiNoEstaEnFitxer(){
        String nom = "Maria";

        gestio.guardaPersona(new Persona("Juan", 55));
        gestio.guardaPersona(new Persona("Matusalem", 12));

        List<Persona> personesCercades = gestio.cercaPerNom(nom);

        assertEquals(0, personesCercades.size());
    }
}