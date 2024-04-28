package com.local.blockchain;

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;

public class Cartera {
    private PublicKey clavePublica;
    private PrivateKey clavePrivada;
    private String direccion;

    public Cartera() {
        this.generarClaves();
        try {
            this.generarDireccion();
        } catch (Exception ex) {
            Logger.getLogger(Cartera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generarClaves() {
        KeyPairGenerator keyPairGenerator = null;

        try {
            keyPairGenerator = KeyPairGenerator.getInstance("EC");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256r1");
            keyPairGenerator.initialize(ecSpec);

            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            this.clavePrivada = keyPair.getPrivate();
            this.clavePublica = keyPair.getPublic();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Cartera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(Cartera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generarDireccion() throws Exception {
        byte[] pkBytes = clavePublica.getEncoded();
        byte[] hash = DigestUtils.sha256(pkBytes);
        this.direccion = Encoder.encodeToBase58(hash);
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
