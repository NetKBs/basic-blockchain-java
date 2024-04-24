package com.local.blockchain;

import com.local.exepciones.FirmaException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class GestorFirmas {
    private GestorFirmas(){}
    
    public static boolean verificarFirma(Transaccion transaccion) {
        PublicKey pk = transaccion.getClavePublica();
        byte[] firma = transaccion.getFirmaDigital();
        byte[] bytes = Serializer.serializarTransaccion(transaccion);

        boolean isCorrect = false;

        try {
            Signature signature = Signature.getInstance("SHA256withECDSA");
            signature.initVerify(pk);
            signature.update(bytes);

            isCorrect = signature.verify(firma);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GestorFirmas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(GestorFirmas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SignatureException ex) {
            Logger.getLogger(GestorFirmas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isCorrect;
    }
    
     public static byte[] generarFirma(PrivateKey privateKey, Transaccion transaccion) throws FirmaException {
        try {
            Signature signature = Signature.getInstance("SHA256withECDSA");
            signature.initSign(privateKey);

            byte[] bytes = Serializer.serializarTransaccion(transaccion);
            signature.update(bytes);
            
            return signature.sign();
        } catch (Exception ex) {
            throw new FirmaException("No se pudo generar la firma");
        }
    }
}
