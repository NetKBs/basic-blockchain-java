
package com.local.blockchain;

import java.util.ArrayList;

public class Sistema {
    
    private static Sistema instancia;
    private ArrayList<Nodo> redNodos = new ArrayList<>();
    
    private Sistema(){}
    
    public static Sistema getInstancia() {
        if (instancia == null) {
            instancia = new Sistema();
        }
        return instancia;
    }
    
    public Nodo crearNodo() {
        Nodo nodoNuevo = new Nodo();
        redNodos.add(nodoNuevo);
        System.out.println("log: nodo creado | id " + nodoNuevo.getId() + " | cartera: " + nodoNuevo.getCartera().getDireccion());
        return nodoNuevo;
    }
    
    public void propagarTransaccion() {
        
    }
    
    public void verificarTransaccion() {
        
    }
    
}
