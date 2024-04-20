
package com.local.blockchain;

public class transcaccion {
    private int id;
    private String emisor; 
    private String receptor;
    private float cantidad;
    private int firmaDigital;
    private String timestamp;

    public transcaccion(String emisor, String receptor, float cantidad, int firmaDigital) {
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

    public int getFirmaDigital() {
        return firmaDigital;
    }

    public String getTimestamp() {
        return timestamp;
    }
    
    
    
}
