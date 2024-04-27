package com.local.blockchain;

import java.time.Instant;
import com.local.exepciones.FirmaException;
import java.security.PublicKey;
import java.security.PrivateKey;

public class Nodo {

    protected int id;
    protected Cartera cartera;
    protected Cadena cadena;
    private Sistema redP2P = null; // acceso a la red de nodos

    public Nodo() {
        this.cartera = new Cartera();
        this.cadena = new Cadena();
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void conectarseRedP2P() {
        this.redP2P = Sistema.getInstancia();
        redP2P.conectarNodoARed(this);
    }

    public Transaccion crearTransaccion(String receptor, float monto) throws FirmaException {
        String direccion = cartera.getDireccion();
        PublicKey clavePublica = cartera.getClavePublica();
        PrivateKey clavePrivada = cartera.getClavePrivada();
        Instant timestamp = Instant.now();

        Transaccion nuevaTransaccion = new Transaccion(direccion, receptor, monto, timestamp, clavePublica);
        byte[] firma = GestorFirmas.generarFirma(clavePrivada, nuevaTransaccion);
        nuevaTransaccion.firmar(firma);

        return nuevaTransaccion;
    }
    
    public void agregarBloque(Bloque bloque){
        
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
