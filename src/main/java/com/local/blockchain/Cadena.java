package com.local.blockchain;

import java.util.HashMap;

public class Cadena {

    private HashMap<String, Bloque> bloques = new HashMap<>();
    private HashMap<String, Integer> heads = new HashMap<>();
    private String headMayor = null;

    public Cadena() {
    }

    public void agregarBloque(Bloque bloque) {
        String anterior = bloque.getHashAnterior();
        String hash = bloque.getHash();
        
        if(bloques.containsKey(hash)){
            return;
        }
        
        Integer indice = bloque.getIndice();

        if (anterior == null && indice == 0) {
            heads.put(hash, indice);
            bloques.put(hash, bloque);
            actualizarHeadMayor(bloque);
            return;
        }

        Bloque bloqueAnterior = bloques.get(anterior);
        Integer indiceAnterior = bloqueAnterior.getIndice();

        if (indice != indiceAnterior + 1) {
            return;
        }

        if (heads.containsKey(anterior)) {
            heads.remove(anterior);
        }

        heads.put(hash, indice);
        bloques.put(hash, bloque);

        actualizarHeadMayor(bloque);
    }

    private void actualizarHeadMayor(Bloque nuevoBloque) {
        Integer indice = nuevoBloque.getIndice();

        if (headMayor == null) {
            headMayor = nuevoBloque.getHash();
        }

        Bloque headActual = bloques.get(headMayor);
        Integer indiceActual = headActual.getIndice();

        if (indice > indiceActual) {
            headMayor = nuevoBloque.getHash();
        }
    }

    public Bloque obtenerBloque(String hash) {
        return bloques.get(hash);
    }

    public String[] obtenerHeads() {
        return (String[]) heads.keySet().toArray();
    }

    public String obtenerHeadMayor() {
        return headMayor;
    }
}
