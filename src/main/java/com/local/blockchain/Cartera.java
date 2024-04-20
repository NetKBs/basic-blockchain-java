
package com.local.blockchain;

public class Cartera {
    
    private String clavePublica;
    private String clavePrivada;
    private String direccion;
    private float fondos;
    
    public Cartera() {
        this.clavePublica = "ClavePublica";
        this.clavePrivada = "ClavePrivada";
        this.direccion = "Direccion";
        this.fondos = 0;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public String getClavePublica() {
        return clavePublica;
    }

    public String getClavePrivada() {
        return clavePrivada;
    }
    
    
    
}
