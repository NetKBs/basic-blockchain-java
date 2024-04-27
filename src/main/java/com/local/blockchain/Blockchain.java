
package com.local.blockchain;


import com.local.blockchain.views.PrincipalView;
import com.local.exepciones.FirmaException;


public class Blockchain {
    

    public static void main(String[] args) throws FirmaException {

       PrincipalView viewPrincipal = new PrincipalView();
       viewPrincipal.setVisible(true);
       /*
       Nodo nodo = new Nodo();
       Minero minero = new Minero();
       minero.transaccionesValidas().add(new Transaccion("dfsd", "asdf", 324, new Instant(), new PublicKey()));
       Bloque b = minero.crearBloque();
       nodo.getCadena().agregarBloque(b);
       
       for (String head : nodo.getCadena().obtenerHeads()) {
            Bloque bloque = nodo.getCadena().obtenerBloque(head);
            System.out.println("Hash Anterior:" + bloque.getHashAnterior());
            System.out.println("Transacciones:");
            for (Transaccion transaccion : bloque.getTransacciones()) {
                System.out.println("ID:" + transaccion.getId());
                System.out.println("Emisor:" + transaccion.getEmisor());
                System.out.println("Receptor:" + transaccion.getReceptor());
                System.out.println("Monto:" + transaccion.getCantidad());
                System.out.println("");
            }
            System.out.println("Nonce:" + bloque.getNonce());
            System.out.println("Hash:" + bloque.getHash());
            System.out.println("");
        }*/
       

    }
}
