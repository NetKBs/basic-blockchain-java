
package com.local.blockchain;

import com.local.blockchain.views.Principal;
import com.local.exepciones.FirmaException;

import com.local.exepciones.FirmaException;
import java.security.PublicKey;
import java.util.AbstractMap;

public class Blockchain {
    

    public static void main(String[] args) throws FirmaException {

       //Principal viewPrincipal = new Principal();
       //viewPrincipal.setVisible(true);
       Sistema sistema = Sistema.getInstancia();
       
       // Nodos 
       Nodo nodo1 = new Nodo();
       nodo1.conectarseRedP2P();
       
       // Nodos Mineros
       Minero minero1 = new Minero();
       minero1.conectarseRedP2P();
       
       Minero minero2 = new Minero();
       minero2.conectarseRedP2P();
       
       Minero minero3 = new Minero();
       minero3.conectarseRedP2P();
       
       // Procesos en la red
       sistema.propagarTransaccion(nodo1.crearTransaccion("direccion", 10));

    }
}
