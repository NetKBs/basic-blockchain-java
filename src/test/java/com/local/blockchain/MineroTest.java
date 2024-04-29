
package com.local.blockchain;

import com.local.exepciones.FirmaException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MineroTest {
    
    private static Minero minero;
    
    public MineroTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws FirmaException {
        minero = new Minero();
        Transaccion transaccion = minero.crearTransaccion("receptor", 10);
        minero.transaccionesValidas().add(transaccion);
    }
    
    @Test
    public void minarBloque() {
        Bloque bloqueParaMinar = minero.crearBloque();
        Bloque bloqueMinado = minero.minarBloque(bloqueParaMinar);
       
        Assertions.assertNotNull(bloqueMinado.getHash());
        Assertions.assertNotNull(bloqueMinado.getNonce());
    }

}
