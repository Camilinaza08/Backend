import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
public class ListaTest {
    private Lista lista;

    @BeforeEach
    private void ListaSimpleTest(){
        lista = new Lista(2);
    }

    @Test
    @DisplayName("Se pide un posiciòn y està fuera de rango")
    public void GetItemException(){
        assertThrow
    }

    @Test
    @DisplayName("Se pide en una posiciòn y es existosos")
    public void GetItemRetornaElemento(){
        //Arrange
        Alquiler alquiler = new Alquiler();
        alquiler.setCodigo("1234");
        lista.append(alquiler);

        //Act
        Object obtenido = lista.get(0);

        //Assert
        assertNotNull(obtenido);
        assert
    }
    @Test
    @DisplayName("Se agrega elemento en un tamaño inicial")
    public void AppendExitosamenteConTamañoInicial(){
        //Arrange
        Alquiler alquiler = new Alquiler();
        alquiler.setCodigo("12345");
        //Act
        lista.append(alquiler);
        //Assert
        assertNotNull(lista.get(0));
        assertEquals(alquiler.getCodigo(), ((Alquiler)lista.get(0).getCodigo()));
        assertInstanceOf(Alquiler.class, lista.get(0));


        @Test
        @DisplayName("Se agrega elemento cuando excedio la capacidad")
        public void AppendExitosamenteConDesborde(){
            // Arrange
            for(int i = 0; i < lista.size(); i++){
                Alquiler alquiler = new Alquiler();
                alquiler.setCodigo(Integer.toString(i))
                lista.append(alquiler)
            }

            //Act
            Alquiler nuevo = new Alquiler();
            nuevo.setCodigo("1234");

            lista.append(nuevo);

            //Assert
            assertEquals(lista.size(), 4);
            assertNotNull(lista.get(2));
            assertInstanceOf(Alquiler.class, lista.get(2));
            assertEquals(nuevo.getCodigo(), ((Alquiler)lista.get(2).getCodigo()));
        }

    }

}
