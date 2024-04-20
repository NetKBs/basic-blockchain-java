
package com.local.blockchain;

public class Nodo {
    private static int id;
    private Cartera cartera;
    private Cadena cadena;

    public Nodo(){
        this.id += 1;
        this.cartera = new Cartera();
        this.cartera.setDireccion(id+"cartera");
    }

    public static int getId() {
        return id;
    }
    
    
    public void transaccion(String receptor, float monto) {
        GestorTransacciones gestor = new GestorTransacciones();
        // Generar la firma digital:hash(datos+clavPriv+clavPub)
        String datosTransaccion = receptor + cartera.getDireccion() + monto;
        String firma = datosTransaccion + cartera.getClavePrivada() + cartera.getClavePublica();
        
        gestor.hacerTransaccion(receptor, this, monto, firma);
    }
    
    public String getDireccionCartera() {
        return cartera.getDireccion();
    }
    
    public String generarFirmaDigital() {
        // Algoritmo respectivo....
        return cartera.getClavePrivada() + this.getClavePublica();
    }
    
    public String getClavePublica() {
        return cartera.getClavePublica();
    }

    public Cadena getCadena() {
        return cadena;
    }
    
    public Cartera getCartera() {
        return cartera;
    }
    
    
}
