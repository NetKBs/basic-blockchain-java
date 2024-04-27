package com.local.blockchain;

import java.util.ArrayList;

public class Sistema {
    
    private static Sistema instancia;
    private int contadorNodo = 0;
    private ArrayList<Nodo> redNodos = new ArrayList<>();
    
    private Sistema(){}
    
    public static Sistema getInstancia() {
        if (instancia == null) {
            instancia = new Sistema();
        }
        return instancia;
    }
    
    public void propagarBloqueYaMinado(Bloque bloque) {
 
        for (Nodo nodo: redNodos) {
            
            if (nodo instanceof Minero) {
                Minero minero = (Minero) nodo;
                minero.bloqueYaMinado();
            }       
            nodo.cadena.agregarBloque(bloque);
        }   
    }
    
    public String propagarTransaccion(Transaccion transaccion) {
        boolean revisado = false;
        
        for (Nodo nodo: redNodos) {
            if (nodo instanceof Minero) {
                revisado = true;
                Minero minero = (Minero) nodo;
                String respuesta = minero.validarTransaccion(transaccion);
                
                // TODO: VERIFICAR FONDOS
                if (!respuesta.isEmpty()) {
                    return "Nodo Minero #" +  minero.getId() + " desaprueba la transaccion:\n"+respuesta;
                }
            } 
        }
        
        if (!revisado) {
            return "No existen mineros para validar las transacciones";
        }
        
        // TODO: PASAR TRANSACCIÓN A LOS MINEROS PARA PODER MINAR LUEGO
    
        return "";
    }
    
    // TODO: verificar si la instancia de nodo ya está en la red conectada
    
    public void conectarNodoARed(Nodo nodo) {
        redNodos.add(nodo);
    }
    
    public Nodo crearConectarNodoRed(boolean minero) {
        Nodo nodo;
        if (minero) {
            nodo = new Minero();
        } else {
            nodo = new Nodo();
        }
        
        nodo.setId(generarNuevoIdUnico());
        redNodos.add(nodo);
        return nodo;
    }
    
    private int generarNuevoIdUnico() {
        return ++contadorNodo;
    }
    
  public ArrayList<Nodo> getRedNodos() {
      return redNodos;
  }
  
  public void imprimir() {
      for (Nodo nodo: redNodos) {
        System.out.println(nodo.getId());        

      }
  }
 
  public Nodo getNodoById(int id) {
      for (Nodo nodo : redNodos) {
          if (nodo.getId() == id) { 
            return nodo;
        }
    }
    return null;
  }
}
