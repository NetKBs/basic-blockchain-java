package com.local.blockchain;

import java.time.Instant;
import java.util.ArrayList;

public class Minero extends Nodo {
    private ArrayList<Transaccion> transaccionesValidadas = new ArrayList<>();
    private final Integer transaccionesPorBloque = 1;

    public Minero (){
        super();
    }
    
    public String validarTransaccion(Transaccion transaccion) {
     
        if (!this.verificarFondos(transaccion)) {
            return "Fondos insuficientes";
        } else if (!this.verificarDireccion(transaccion)) {
            return "Direccion de cartera incorrecta";
        } else if (!GestorFirmas.verificarFirma(transaccion)) {
            return "Error en la firma digital";
        }

        transaccionesValidadas.add(transaccion);
        return "";
    }
    
    private boolean verificarDireccion(Transaccion transaccion) {
        String direccion = transaccion.getReceptor();
        
        for (Nodo nodo : Sistema.getInstancia().getRedNodos()) {
            if (!(nodo instanceof Minero)) {
                if (direccion.equals(nodo.getDireccionCartera())) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean verificarFondos(Transaccion transaccion) {
        return true;
    }

    public Bloque crearBloque() {
        if (!deberiaCrearBloque()) {
            return null;
        }

        Instant timestamp = Instant.now();
        String hashAnterior = this.getHashAnterior();
        Integer indiceAnteror = this.getIndiceAnterior();
        Bloque nuevoBloque = new Bloque(indiceAnteror  + 1, timestamp.toString(), transaccionesValidadas, hashAnterior);

        return nuevoBloque;
    }
    
    public void bloqueYaMinado() {
        transaccionesValidadas = new ArrayList<>();
    }

    public Bloque minarBloque(Bloque bloque) {
        int i = 0;

        while (!bloque.esValido() && deberiaCrearBloque()) {
            bloque.crearHash(i);
            i++;
        }
        
        if (bloque.esValido()) {
            transaccionesValidadas = new ArrayList<>();
            Sistema.getInstancia().propagarBloqueYaMinado();
            return bloque;
        } else {
            return null;
        }
        
    }

    public Boolean deberiaCrearBloque() {
        return transaccionesValidadas.size() >= transaccionesPorBloque;
    }

    public String getHashAnterior() {
        return cadena.obtenerHeadMayor();
    }
    
    public Integer getIndiceAnterior(){
        String headMayor = getHashAnterior();
        
        if(headMayor == null){
            return -1;
        }
        
        return cadena.obtenerBloque(headMayor).getIndice();
    }

}
