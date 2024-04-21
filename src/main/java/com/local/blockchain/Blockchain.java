
package com.local.blockchain;
import org.apache.commons.codec.digest.DigestUtils;


public class Blockchain {

    public static void main(String[] args) {
        Nodo nodo1 = new Nodo();  
        Nodo nodo2 = new Nodo();
        
        nodo1.transaccion("pedro", 30);
        
        // Pasando pago movils qlq
      
        
       /* String originalString = "Tu texto aquí";
        String sha256hex = DigestUtils.sha256Hex(originalString);
        System.out.println(sha256hex);
        */
    }
}
