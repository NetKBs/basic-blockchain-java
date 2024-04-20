
package com.local.blockchain;

import java.util.ArrayList;

public class Bloque {
    private int indice;
    private String timestamp;
    private ArrayList<Transaccion> listTrans;
    private String hashAnterior;
    private String hash;
    private String nonce;

    public Bloque() {
    }

    public int getIndice() {
        return indice;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public ArrayList<Transaccion> getListTrans() {
        return listTrans;
    }

    public String getHashAnterior() {
        return hashAnterior;
    }

    public String getHash() {
        return hash;
    }

    public String getNonce() {
        return nonce;
    }
    
    
    
}
