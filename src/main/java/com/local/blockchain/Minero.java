
package com.local.blockchain;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Minero extends Nodo{
 
    
    public boolean verificarTransaccion(Transaccion transaccion, PublicKey pk) {
        boolean veredicto;
        
        String datos = transaccion.getEmisor() + transaccion.getReceptor() + 
                       transaccion.getCantidad() + transaccion.getTimestamp();
        
        // firma
        if (!verificarFirma(pk, datos, transaccion.getFirmaDigital())) {
            return false;
        }
        
        // saldo
        // TODO: Verificar el saldo a través del blockchain
        
        /*if (!verificarSaldo(transaccion.getEmisor())) {
           return false; 
        }*/
        
        return true;
    }
    
    public boolean verificarSaldo(String emisor) {
        boolean isCorrect = false;
        return isCorrect;
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

}
