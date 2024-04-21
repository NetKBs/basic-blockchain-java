
package com.local.blockchain;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Nodo {
    private static int id;
    private Cartera cartera;
    private Cadena cadena;

    public Nodo(){
        this.id += 1;
        this.cartera = new Cartera();
    }

    public static int getId() {
        return id;
    }
    
    
    public void transaccion(String receptor, float monto) {
        GestorTransacciones gestor = new GestorTransacciones();        
        Instant timestamp = Instant.now();
        String datos = cartera.getDireccion() + receptor + monto + timestamp;
        byte[] firma = generarFirma(datos);
  
        
        if (firma != null) {
            Transaccion transaccion = new Transaccion(cartera.getDireccion(), receptor, monto, timestamp, firma);
            gestor.procesarTransaccion(cartera.getClavePublica(), transaccion);
            
        }
        return;
    }
    
    private byte[] generarFirma(String datos) {
        // Crear un objeto Signature e inicializarlo para la firma
        Signature signature = null;
        try {
            signature = Signature.getInstance("SHA256withECDSA");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GestorTransacciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            signature.initSign(cartera.getClavePrivada());
        } catch (InvalidKeyException ex) {
            Logger.getLogger(GestorTransacciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Pasar los datos a firmar al objeto Signature
        byte[] bytes = datos.getBytes(StandardCharsets.UTF_8);
        try {
            signature.update(bytes);
        } catch (SignatureException ex) {
            Logger.getLogger(GestorTransacciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // Firmar los datos
            byte[] digitalSignature = signature.sign();
            return digitalSignature;
        } catch (SignatureException ex) {
            Logger.getLogger(GestorTransacciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String getDireccionCartera() {
        return cartera.getDireccion();
    }
    
    public Cadena getCadena() {
        return cadena;
    }
    
    public Cartera getCartera() {
        return cartera;
    }
    
    
}
