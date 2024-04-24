package com.local.blockchain;

import java.nio.charset.StandardCharsets;

public final class Serializer {

    private Serializer() {
    }

    public static byte[] serializarBloque(Bloque bloque) {
        String datos = bloque.getIndice() + bloque.getTimestamp() + bloque.getTransacciones() + bloque.getHashAnterior() + bloque.getNonce();
        return datos.getBytes();
    }
    
    public static byte[] serializarTransaccion(Transaccion transaccion){
         String datos = transaccion.getEmisor() + transaccion.getReceptor()
                + transaccion.getCantidad() + transaccion.getTimestamp();
         
         return datos.getBytes(StandardCharsets.UTF_8);
    }
}
