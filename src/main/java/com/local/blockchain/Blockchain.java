
package com.local.blockchain;

public class Blockchain {

    public static void main(String[] args) {
        Nodo nodo1 = new Nodo();
        Nodo nodo2 = new Nodo();
        
        // Pasando pago movils qlq
        nodo1.transaccion(nodo2.getDireccionCartera(), 10);
        nodo1.transaccion(nodo2.getDireccionCartera(), 30);
        nodo2.transaccion(nodo1.getDireccionCartera(), 16);
        
    }
}
