
import com.local.blockchain.GestorFirmas;
import com.local.blockchain.Nodo;
import com.local.blockchain.Transaccion;
import com.local.exepciones.FirmaException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class transaccionTest {
    
    private static Nodo nodo;
    
    public transaccionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        nodo = new Nodo();
    }
 
    @Test
    public void generaciónFirma() throws FirmaException {
        
    }
    
    @Test
    public void verificaciónFirma() {
        
    }
    
    
}
