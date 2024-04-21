
package com.local.blockchain;



public class Blockchain {

    public static void main(String[] args) {
        Nodo nodo1 = new Nodo();  
        Nodo nodo2 = new Nodo();
        Nodo nodo3 = new Nodo();
        
        System.out.println(nodo1.getCartera().getDireccion());
        System.out.println(nodo2.getCartera().getDireccion());
        System.out.println(nodo3.getCartera().getDireccion());
        
        System.out.println();
        
       
        //nodo1.transaccion("pedro", 30);
        
        // Pasando pago movils qlq
      
        
       /* String originalString = "Tu texto aquí";
        String sha256hex = DigestUtils.sha256Hex(originalString);
        System.out.println(sha256hex);
        */
    }
}
