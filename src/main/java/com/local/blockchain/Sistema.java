
package com.local.blockchain;

import java.util.ArrayList;

public class Sistema {
    
    private ArrayList<Nodo> redNodos = new ArrayList<>();
    
    public Sistema(){
        
    }
    
    public void crearNodo() {
        
        Nodo nodoNuevo = new Nodo();
        //redNodos.add(nodoNuevo);
        
        if (!redNodos.isEmpty()) {      
            for (Nodo nodo : redNodos) {
                nodo.agregarNodoConocido(nodoNuevo);
            }
        }
        
        nodoNuevo.setNodosConocidos(redNodos);    
        System.out.println("Todo bien");
    }
    
}
