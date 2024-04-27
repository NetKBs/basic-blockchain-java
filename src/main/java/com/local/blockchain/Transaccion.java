package com.local.blockchain;

import com.local.exepciones.FirmaException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.time.Instant;

public class Transaccion {
    private static int idContador;
    private int id;
    private String emisor;
    private String receptor;
    private float cantidad;
    private byte[] firmaDigital;
    private Instant timestamp;
    private PublicKey pk;

    public Transaccion(String emisor, String receptor, float cantidad, Instant timestamp, PublicKey pk) {
        this.id = ++idContador;
        this.emisor = emisor;
        this.receptor = receptor;
        this.cantidad = cantidad;
        this.timestamp = timestamp;
        this.pk = pk;
    }

    public int getId() {
        return id;
    }

    public String getEmisor() {
        return emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public float getCantidad() {
        return cantidad;
    }

    public byte[] getFirmaDigital() {
        return firmaDigital;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public PublicKey getClavePublica() {
        return pk;
    }
    
    public void firmar(byte[] firma){
        this.firmaDigital = firma;
    }
    
    public Boolean esValida(){
        return (firmaDigital != null);
    }
}
