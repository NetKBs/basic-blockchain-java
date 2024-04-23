
package com.local.blockchain;

import java.util.ArrayList;

public class Sistema {
    
    private ArrayList<Nodo> redNodos = new ArrayList<>();
    
    public Sistema(){
        
    }
    
    public Nodo crearNodo() {
        Nodo nodoNuevo = new Nodo();
        redNodos.add(nodoNuevo);
        System.out.println("log: nodo creado | id " + nodoNuevo.getId() + " | cartera: " + nodoNuevo.getCartera().getDireccion());
        return nodoNuevo;
    }
    
}
