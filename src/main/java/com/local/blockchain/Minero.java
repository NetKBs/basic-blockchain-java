package com.local.blockchain;

import java.time.Instant;
import java.util.ArrayList;

public class Minero extends Nodo {

    private ArrayList<Transaccion> transaccionesValidadas = new ArrayList<>();
    private Integer transaccionesPorBloque = 1;
    private Integer limiteIntentos = 1_000_000;

    public void validarTransaccion(Transaccion transaccion) {
        if (!this.verificarFirma(transaccion) || !this.verificarFondos(transaccion)) {
            return;
        }

        transaccionesValidadas.add(transaccion);
    }

    private Boolean verificarFirma(Transaccion transaccion) {
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
        Bloque nuevoBloque = new Bloque(0, timestamp.toString(), transaccionesValidadas, hashAnterior);

        return nuevoBloque;

    }

    public void minarBloque(Bloque bloque) {
        int i = 0;

        while (i < limiteIntentos && !bloque.esValido()) {
            bloque.crearHash(i);
            i++;
        }
    }

    public Boolean deberiaCrearBloque() {
        return transaccionesValidadas.size() >= transaccionesPorBloque;
    }

    public String getHashAnterior() {
        return null;
    }

}
