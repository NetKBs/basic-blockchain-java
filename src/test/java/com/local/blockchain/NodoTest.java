
package com.local.blockchain;

import com.local.exepciones.FirmaException;
import com.local.blockchain.Transaccion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class NodoTest {
    
    private static Nodo nodo;
    
    public NodoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        nodo = new Nodo();
    }

    @Test
    public void crearTransaccion() throws FirmaException {
        Transaccion transaccion = nodo.crearTransaccion("receptor", 10);
        Assertions.assertNotNull(transaccion);
        Assertions.assertNotNull(transaccion.getFirmaDigital());
    }


}
