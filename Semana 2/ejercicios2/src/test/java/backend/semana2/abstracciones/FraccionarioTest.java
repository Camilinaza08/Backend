package backend.semana2.abstracciones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class FraccionarioTest {
    
    @Test
    public void sumaFraccionarioEsExitosa(){
        //Arrange
        Fraccionario f1 = new Fraccionario(7,8);
        Fraccionario f2 = new Fraccionario(5,4);

        //Act
        Fraccionario suma = f1.suma(f2);

        //Assert
        assertNotNull(suma);
        assertEquals(suma.getNumerador(), 28);
        assertEquals(suma.getDenominador(), 40);
    }
}
