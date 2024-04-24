package com.local.blockchain;

import java.time.Instant;
import java.util.ArrayList;

public class Minero extends Nodo {

    private final ArrayList<Transaccion> transaccionesValidadas = new ArrayList<>();
    private final Integer transaccionesPorBloque = 1;

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
        Bloque nuevoBloque = new Bloque(0, timestamp.toString(), transaccionesValidadas, hashAnterior);

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
        return null;
    }

}
