
package com.local.blockchain;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.time.Instant;
import java.util.ArrayList;

public class Minero extends Nodo {

    private ArrayList<Transaccion> transaccionesValidadas = new ArrayList<>();
    private Integer transaccionesPorBloque = 1;
    private Integer limiteIntentos = 1_000_000;

    public boolean validarTransaccion(Transaccion transaccion) {
        String datos = transaccion.getEmisor() + transaccion.getReceptor() + 
                       transaccion.getCantidad() + transaccion.getTimestamp();
        
        if (!this.verificarFirma(transaccion.getClavePublica(), datos, transaccion.getFirmaDigital()) || 
            !this.verificarFondos(transaccion.getEmisor())) {
            return false;
        }

        transaccionesValidadas.add(transaccion);
        return true;
    }

     public boolean verificarFirma(PublicKey pk, String datos, byte[] firma) {
     
        // Crear un objeto Signature e inicializarlo para la verificación
        Signature signature = null;
        
        try {
            signature = Signature.getInstance("SHA256withECDSA");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GestorTransacciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            signature.initVerify(pk);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(GestorTransacciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Pasar los datos que fueron firmados al objeto Signature
        byte[] bytes = datos.getBytes(StandardCharsets.UTF_8);
        try {
            signature.update(bytes);
        } catch (SignatureException ex) {
            Logger.getLogger(GestorTransacciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Verificar la firma
        boolean isCorrect = false;
        try {
            isCorrect = signature.verify(firma);
        } catch (SignatureException ex) {
            Logger.getLogger(GestorTransacciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isCorrect;
    }
    

    private Boolean verificarFondos(String emisorDir) {
        return true;
    }

    public Bloque crearBloque() {
        if (!deberiaCrearBloque()) {
            return null;
        }

        Instant timestamp = Instant.now();
        String hashAnterior = this.getHashAnterior();
        Bloque nuevoBloque = new Bloque(0, timestamp.toString(), transaccionesValidadas, hashAnterior);

        return nuevoBloque;

    }

    public void minarBloque(Bloque bloque) {
        int i = 0;

        while (i < limiteIntentos && !bloque.esValido()) {
            bloque.crearHash(i);
            i++;
        }
    }

    public Boolean deberiaCrearBloque() {
        return transaccionesValidadas.size() >= transaccionesPorBloque;
    }

    public String getHashAnterior() {
        return null;
    }

}
