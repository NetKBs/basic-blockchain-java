package com.local.blockchain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;

public class BloqueTest {

    @Test
    public void creaHash() {
        Integer indice = 0;
        String timestamp = "";
        ArrayList<Transaccion> transacciones = new ArrayList<>();
        String hashAnterior = "";

        Bloque bloque = new Bloque(indice, timestamp, transacciones, hashAnterior);

        Assertions.assertNull(bloque.getNonce());
        Assertions.assertNull(bloque.getMinero());
        Assertions.assertNull(bloque.getHash());
        
        Integer nonce = 0;
        String minero ="";
        
        bloque.crearHash(nonce, minero);
        
        Assertions.assertEquals(bloque.getNonce(), nonce);
        Assertions.assertEquals(bloque.getMinero(), minero);
        Assertions.assertNotNull(bloque.getHash());
    }
}
