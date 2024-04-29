package com.local.blockchain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.Instant;
import com.local.exepciones.FirmaException;
import java.security.*;

public class GestorFirmasTest {
    @Test
    public void firmaTransaccion() throws FirmaException{
        Cartera cartera = new Cartera();
        PrivateKey clavePrivada = cartera.getClavePrivada();
        PublicKey clavePublica = cartera.getClavePublica();
        Transaccion transaccion = new Transaccion("emisor", "receptor", 100, Instant.now(), clavePublica);
        
        byte[] firma = GestorFirmas.generarFirma(clavePrivada, transaccion);
        
        transaccion.firmar(firma);
        
        boolean esValida = GestorFirmas.verificarFirma(transaccion);
        
        Assertions.assertTrue(esValida);
    }
}
