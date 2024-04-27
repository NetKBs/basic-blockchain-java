
package com.local.blockchain;


import com.local.blockchain.views.PrincipalView;
import com.local.exepciones.FirmaException;

public class Blockchain {
    public static void main(String[] args) throws FirmaException {
       PrincipalView viewPrincipal = new PrincipalView();
       viewPrincipal.setVisible(true);
    }
}
