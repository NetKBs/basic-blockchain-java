package com.local.blockchain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class CadenaTest {

    private static Cadena cadena;

    @BeforeAll
    public static void iniciarCadena() {
        cadena = new Cadena();

        Bloque bloque1 = new Bloque(0, "1", new ArrayList(), null);
        bloque1.crearHash(0, "");
        cadena.agregarBloque(bloque1);

        Bloque bloque2version1 = new Bloque(1, "21", new ArrayList(), bloque1.getHash());
        bloque2version1.crearHash(0, "");
        cadena.agregarBloque(bloque2version1);

        Bloque bloque2version2 = new Bloque(1, "22", new ArrayList(), bloque1.getHash());
        bloque2version2.crearHash(0, "");
        cadena.agregarBloque(bloque2version2);

        Bloque bloque2version3 = new Bloque(1, "23", new ArrayList(), bloque1.getHash());
        bloque2version3.crearHash(0, "");
        cadena.agregarBloque(bloque2version3);
    }

    @Test
    public void mantieneVariasVersiones() {
        Assertions.assertEquals(3, cadena.obtenerHeads().length);
    }

    @Test
    public void mantieneUnaVersionValida() {
        Assertions.assertNotNull(cadena.obtenerHeadMayor());
    }
}
