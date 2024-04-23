
package com.local.blockchain;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Nodo {
    private static int id;
    private Cartera cartera;
    private Cadena cadena;
    private ArrayList<Nodo> redNodosConocidos = new ArrayList<>();

    public Nodo(){
        this.id += 1;
        this.cartera = new Cartera();
    }

    public static int getId() {
        return id;
    }
    
    
    public void transaccion(String receptor, float monto) {
        GestorTransacciones gestor = new GestorTransacciones();        
        Instant timestamp = Instant.now();
        String datos = cartera.getDireccion() + receptor + monto + timestamp;
        byte[] firma = generarFirma(datos);
  
        if (firma != null) {
            Transaccion transaccion = new Transaccion(cartera.getDireccion(), receptor, monto, timestamp, firma);
            gestor.procesarTransaccion(cartera.getClavePublica(), transaccion);
            
        }
        return;
    }
    
    private byte[] generarFirma(String datos) {
        // Crear un objeto Signature e inicializarlo para la firma
        Signature signature = null;
        try {
            
            signature = Signature.getInstance("SHA256withECDSA");
            signature.initSign(cartera.getClavePrivada());
            byte[] bytes = datos.getBytes(StandardCharsets.UTF_8);
            signature.update(bytes);
            byte[] digitalSignature = signature.sign();  
            return digitalSignature;
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GestorTransacciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(GestorTransacciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SignatureException ex) {
            Logger.getLogger(GestorTransacciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void agregarNodoConocido(Nodo nodo) {
        redNodosConocidos.add(nodo);
    }
    
    public void setNodosConocidos(ArrayList<Nodo> nodos) {
        redNodosConocidos = nodos;
    }
    
    public String getDireccionCartera() {
        return cartera.getDireccion();
    }
    
    public Cadena getCadena() {
        return cadena;
    }
    
    public Cartera getCartera() {
        return cartera;
    }
    
    
}
