
package com.local.blockchain;

import java.security.*;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorTransacciones {
    
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
    
    public void procesarTransaccion(PublicKey pk, Transaccion transaccion) {
        
        String datos = transaccion.getEmisor() + transaccion.getReceptor() 
                    + transaccion.getCantidad() + transaccion.getTimestamp();
        
        boolean verificar = verificarFirma(pk, datos, transaccion.getFirmaDigital());
        if (!verificar) {
            System.out.println("Firma digital fraudulenta");
        } else {
            System.out.println("Firma digital comprobada");
        }
    }
    
    
    
    
}
