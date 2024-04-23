
package com.local.blockchain;

import java.util.ArrayList;
import org.apache.commons.codec.digest.DigestUtils;

public class Bloque {
    private int indice;
    private String timestamp;
    private ArrayList<Transaccion> transacciones;
    private String hashAnterior;
    private String hash = null;
    private Integer nonce = null;
    
    public Bloque(int indice, String timestamp, ArrayList<Transaccion> transacciones, String hashAnterior) {
        this.indice = indice;
        this.timestamp = timestamp;
        this.transacciones = transacciones;
        this.hashAnterior = hashAnterior;
    }
    
    public void crearHash(int nonce) {
        String datos = indice + timestamp + transacciones + hashAnterior + nonce;
        byte[] bytes = datos.getBytes();
        byte[] hash = DigestUtils.sha256(bytes);
        Utils encoder = new Utils();
        
        this.hash = encoder.encodeToHex(hash);
        this.nonce = nonce;
    }
    
    public int getIndice() {
        return indice;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public ArrayList<Transaccion> getTransacciones() {
        return transacciones;
    }

    public String getHashAnterior() {
        return hashAnterior;
    }

    public String getHash() {
        return hash;
    }

    public Integer getNonce() {
        return nonce;
    }
    
    public Boolean esValido(){
        if(hash == null || nonce == null){
            return false;
        }
        
        return hash.startsWith("0000");
    }
}
