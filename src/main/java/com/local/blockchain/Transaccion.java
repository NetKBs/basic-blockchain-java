
package com.local.blockchain;

public class Transaccion {
    private int id;
    private String emisor; 
    private String receptor;
    private float cantidad;
    private String firmaDigital;
    private String timestamp;

    public Transaccion(String emisor, String receptor, float cantidad, String firmaDigital) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.cantidad = cantidad;
        this.firmaDigital = firmaDigital;
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

    public String getFirmaDigital() {
        return firmaDigital;
    }

    public String getTimestamp() {
        return timestamp;
    }
    
    
    
}
