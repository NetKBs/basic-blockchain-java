package com.local.blockchain;

import java.time.Instant;
import java.util.ArrayList;

public class Minero extends Nodo {
    private final ArrayList<Transaccion> transaccionesValidadas = new ArrayList<>();
    private final Integer transaccionesPorBloque = 1;

    public Minero (){
        super();
    }
    
    public Boolean validarTransaccion(Transaccion transaccion) {
        if (!GestorFirmas.verificarFirma(transaccion)
                || !this.verificarFondos(transaccion)) {
            return false;
        }

        transaccionesValidadas.add(transaccion);
        return true;
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

    public void minarBloque(Bloque bloque) {
        int i = 0;

        while (!bloque.esValido()) {
            bloque.crearHash(i);
            i++;
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
