
package com.local.blockchain;

import com.local.blockchain.views.Principal;

import com.local.exepciones.FirmaException;

public class Blockchain {

    public static void main(String[] args) {
        
//       Principal viewPrincipal = new Principal();
//       viewPrincipal.setVisible(true);
     
        Nodo nodoEmisor = new Nodo();
        Nodo nodoReceptor = new Nodo();
        
        Cartera carteraEmisora = nodoEmisor.getCartera();
        Cartera carteraReceptora = nodoReceptor.getCartera();
        
        Minero minero = new Minero();
        
        try {
            Transaccion transaccionRealizada = nodoEmisor.crearTransaccion(carteraReceptora.getDireccion(), 10);
            
            System.out.println("transaccion firmada");
            
            minero.validarTransaccion(transaccionRealizada);
            
            if(minero.deberiaCrearBloque()){
                Bloque nuevoBloque = minero.crearBloque();
                minero.minarBloque(nuevoBloque);
            }
            
        } catch(FirmaException e){
            System.out.println("Se firmo mal esa vaina");
        }
    }
}
