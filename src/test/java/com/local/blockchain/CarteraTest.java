package com.local.blockchain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;

import java.security.*;

public class CarteraTest {

    private static Cartera cartera;

    @BeforeAll
    public static void crearCartera() {
        cartera = new Cartera();
    }

    @Test
    public void generaClavesYDireccion() {
        Assertions.assertNotNull(cartera.getClavePrivada());
        Assertions.assertNotNull(cartera.getClavePublica());
        Assertions.assertNotNull(cartera.getDireccion());
    }

    @Test
    public void usaAlgoritmoECDSA() {
        PublicKey clavePublica = cartera.getClavePublica();
        PrivateKey clavePrivada = cartera.getClavePrivada();

        Assertions.assertEquals("EC", clavePublica.getAlgorithm());
        Assertions.assertEquals("EC", clavePrivada.getAlgorithm());
    }

    @Test
    public void clavesCoinciden() throws Exception {
        PublicKey clavePublica = cartera.getClavePublica();
        PrivateKey clavePrivada = cartera.getClavePrivada();
        Signature signature = Signature.getInstance("SHA256withECDSA");

        String mensaje = "hola mundo";

        signature.initSign(clavePrivada);
        signature.update(mensaje.getBytes());
        byte[] firma = signature.sign();

        signature.initVerify(clavePublica);
        signature.update(mensaje.getBytes());
        boolean esValida = signature.verify(firma);

        Assertions.assertTrue(esValida);
    }
}
