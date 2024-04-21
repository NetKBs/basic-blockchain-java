
package com.local.blockchain;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;


public class Cartera {
    
    private PublicKey clavePublica;
    private PrivateKey clavePrivada;
    private String direccion;
    private float fondos;
        
    public Cartera() {
        this.generarClaves();
        try {
            this.generarDireccion();
        } catch (Exception ex) {
            Logger.getLogger(Cartera.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.fondos = 0;
    }
    
    public void generarClaves() {
        // Usando algoritmo ECDSA
        KeyPairGenerator keyPairGenerator = null;
        
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("EC"); // algoritmo EC
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Cartera.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256r1"); // Parámetros de la curva
        
        try {
            keyPairGenerator.initialize(ecSpec);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(Cartera.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        this.clavePrivada = keyPair.getPrivate();
        this.clavePublica = keyPair.getPublic();
       
    }
    
    public void generarDireccion() throws Exception {
        // Obtiene la clave publica en formato byte[]
        byte[] pkBytes = clavePublica.getEncoded();
        // Calcula el hash SHA-256 de la clave privada
        byte[] hash = DigestUtils.sha256(pkBytes);
        Utils encoder = new Utils();
        this.direccion = encoder.encodeToBase58(hash);
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public PublicKey getClavePublica() {
        return clavePublica;
    }

    public PrivateKey getClavePrivada() {
        return clavePrivada;
    }
    
    
    
}
