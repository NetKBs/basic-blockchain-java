
package com.local.blockchain;

import java.time.Instant;

public class Transaccion {
    private static int id;
    private String emisor; 
    private String receptor;
    private float cantidad;
    private byte[] firmaDigital;
    private Instant timestamp;

    public Transaccion(String emisor, String receptor, float cantidad, Instant timestamp, byte[] firma) {
        this.id += 1;
        this.emisor = emisor;
        this.receptor = receptor;
        this.cantidad = cantidad;
        this.timestamp = timestamp;
        this.firmaDigital = firma;
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
    
    
    
}
