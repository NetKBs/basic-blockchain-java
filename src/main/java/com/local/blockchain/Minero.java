package com.local.blockchain;

import java.time.Instant;
import java.util.ArrayList;

public class Minero extends Nodo {

    private ArrayList<Transaccion> transaccionesValidadas = new ArrayList<>();
    private final Integer transaccionesPorBloque = 1;

    public Minero() {
        super();
    }

    public String validarTransaccion(Transaccion transaccion) {

        if (!this.verificarFondos(transaccion)) {
            return "Fondos insuficientes";
        } else if (!this.verificarDireccion(transaccion)) {
            return "Direccion de cartera incorrecta";
        } else if(transaccion.getEmisor().equals(transaccion.getReceptor())) {
            return "No te puedes transferir a ti mismo";
        } else if (!GestorFirmas.verificarFirma(transaccion)) {
            return "Error en la firma digital";
        }

        transaccionesValidadas.add(transaccion);
        return "";
    }

    private boolean verificarDireccion(Transaccion transaccion) {
        String direccion = transaccion.getReceptor();

        for (Nodo nodo : Sistema.getInstancia().getRedNodos()) {
            if (direccion.equals(nodo.getDireccionCartera())) {
                return true;
            }
        }
        return false;
    }

    private Boolean verificarFondos(Transaccion transaccion) {
        Bloque bloque = cadena.obtenerBloque( cadena.obtenerHeadMayor());
        String emisor = transaccion.getEmisor();
        
        float saldo = 0;
        
        while (bloque != null) {
            for (Transaccion t : bloque.getTransacciones()) {
                if (emisor.equals(t.getEmisor())) {
                    saldo -= t.getCantidad();
                } else if (emisor.equals(t.getReceptor())) {
                    saldo += t.getCantidad();
                }
            }

            if(emisor.equals(bloque.getMinero())){
                saldo += 50;
            }
            
            bloque = cadena.obtenerBloque(bloque.getHashAnterior());
        }
        
        return saldo >= transaccion.getCantidad();
    }

    public Bloque crearBloque() {
        if (!deberiaCrearBloque()) {
            return null;
        }

        Instant timestamp = Instant.now();
        String hashAnterior = this.getHashAnterior();
        Integer indiceAnteror = this.getIndiceAnterior();
        Bloque nuevoBloque = new Bloque(indiceAnteror + 1, timestamp.toString(), transaccionesValidadas, hashAnterior);

        return nuevoBloque;
    }

    public void bloqueYaMinado() {
        transaccionesValidadas = new ArrayList<>();
    }

    public Bloque minarBloque(Bloque bloque) {
        int i = 0;

        while (!bloque.esValido() && deberiaCrearBloque()) {
            bloque.crearHash(i, cartera.getDireccion());
            i++;
        }

        if (bloque.esValido()) {
            transaccionesValidadas = new ArrayList<>();
            Sistema.getInstancia().propagarBloqueYaMinado(bloque);
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

    public Integer getIndiceAnterior() {
        String headMayor = getHashAnterior();

        if (headMayor == null) {
            return -1;
        }

        return cadena.obtenerBloque(headMayor).getIndice();
    }
    
    @Override
     public float getFondos(){
        Bloque bloque = cadena.obtenerBloque( cadena.obtenerHeadMayor());
        String direccion = cartera.getDireccion();
        float saldo = 0;
        
        while (bloque != null) {
            for (Transaccion t : bloque.getTransacciones()) {
                if (direccion.equals(t.getEmisor())) {
                    saldo -= t.getCantidad();
                } else if (direccion.equals(t.getReceptor())) {
                    saldo += t.getCantidad();
                }
            }
            
            if(direccion.equals(bloque.getMinero())){
                saldo += 50;
            }

            bloque = cadena.obtenerBloque(bloque.getHashAnterior());
        }
        
        return saldo;
    }

    public ArrayList<Transaccion> transaccionesValidas() {
        return transaccionesValidadas;
    }

}
