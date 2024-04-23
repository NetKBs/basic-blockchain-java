
package com.local.blockchain;

import com.local.blockchain.views.Principal;


public class Blockchain {

    public static void main(String[] args) {
        
       Principal viewPrincipal = new Principal();
      // viewPrincipal.setVisible(true);
       Sistema sistema = new Sistema();
       sistema.crearNodo();
       sistema.crearNodo();
    }
}
