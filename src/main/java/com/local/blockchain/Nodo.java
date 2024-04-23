package com.local.blockchain;

import java.nio.charset.StandardCharsets;
import java.security.Signature;
import java.time.Instant;
import com.local.exepciones.FirmaException;
import java.security.PublicKey;

public class Nodo {
    private static int id;
    private Cartera cartera;
    private Cadena cadena;
    private Sistema redP2P = null; // acceso a la red de nodos

    public Nodo() {
        this.id += 1;
        this.cartera = new Cartera();
    }

    public static int getId() {
        return id;
    }
    
    public void conectarseRedP2P() {
        this.redP2P = Sistema.getInstancia();
        redP2P.conectarNodoARed(this);
    }
    
    public void crearTransaccion(String receptor, float monto) throws FirmaException {
        if (redP2P == null) {
            System.out.print("Nodo no tiene acceso a la red");
            
        } else {
            String direccion = cartera.getDireccion();
            Instant timestamp = Instant.now();

            String datos = direccion + receptor + monto + timestamp;
            byte[] firma = this.generarFirma(datos);

            Transaccion transaccion = new Transaccion(direccion, receptor, monto, timestamp, firma);
            redP2P.propagarTransaccion(transaccion, cartera.getClavePublica());
        }
  
    }

    private byte[] generarFirma(String datos) throws FirmaException {
        Signature signature = null;

        try {
            signature = Signature.getInstance("SHA256withECDSA");
            signature.initSign(cartera.getClavePrivada());
            byte[] bytes = datos.getBytes(StandardCharsets.UTF_8);
            signature.update(bytes);
            byte[] digitalSignature = signature.sign();

            return digitalSignature;
        } catch (Exception ex) {
            throw new FirmaException("No se pudo generar la firma");
        }
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
