
package com.local.blockchain;

import java.security.PublicKey;
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
    
    public void propagarTransaccion(Transaccion transaccion) {
        
        boolean revisado = false;

        for (Nodo nodo: redNodos) {
            if (nodo instanceof Minero) {
                revisado = true;
                Minero minero = (Minero) nodo;
                boolean respuesta = minero.validarTransaccion(transaccion);
                if (respuesta) {
                    System.out.println("Nodo " +  minero.getId() + " aprueba la transaccion");
                } else {
                   System.out.println("Nodo " +  minero.getId() + " desaprueba la transaccion");
                }
            } 
        }
        
        if (!revisado) {
            System.out.println("No existen mineros para validar las transacciones");
        }
        
        // TODO: Luego de validarlo todo dar las transaccion como valida a todos los mineros
    }
    
    // TODO: verificar si la instancia de nodo ya está en la red conectada
    
    public void conectarNodoARed(Nodo nodo) {
        redNodos.add(nodo);
        System.out.println("Nodo conectado");
    }
    
    public void crearConectarNodoRed(boolean minero) {
        if (minero) {
            redNodos.add(new Minero());
        } else {
            redNodos.add(new Nodo());
        }
        System.out.println("Nodo creado y conectado");
    }
    
  
    
}
