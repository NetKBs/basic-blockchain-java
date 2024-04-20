
package com.local.blockchain;

public class GestorTransacciones {
    
    public boolean verificarFirma(String datosTransaccion, String firmaPrevia, String clavePub, String clavePriv) {
        
        String firmaNueva = datosTransaccion + clavePriv + clavePub ;

        if (firmaPrevia.equals(firmaNueva)) { // Firma digital real
            return true;
        }
        return false;
    }
    
    public void hacerTransaccion(String receptorDir, Nodo emisor, float monto, String firma) {
        
        String datosTransaccion = receptorDir + emisor.getCartera().getDireccion() + monto;
        Cartera cartera = emisor.getCartera();
        
        if (verificarFirma(datosTransaccion, firma, cartera.getClavePublica(), cartera.getClavePrivada())) {
            System.out.println("Bieeeen");
            return;
        }
        
        System.out.println("Maaal");
   
    }
    
    
}
