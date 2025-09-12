package backend.semana3;
import java.util.Arrays;
import java.util.Iterator;


public class ListaArray implements Iterable{
    private Object[] elementos;
    private int count;

    public ListaArray(int tam){
        elementos = new Object[tam];
        count = 0;
    }

    public void add(Object elemento){
        if(count >= elementos.length){
           int tam = elementos.length * 2 ;
           elementos = Arrays.copyOf(elementos, tam);
           System.out.println("Nuevo tamaño: " + elementos.length);
        }
        elementos[count] = elemento;
        count ++; }
     

    public int size(){
        return count;
    }
    @Override
    public String toString(){
        String cadena = "";
        for (int i = 0; i < count; i++) {
            cadena += elementos[i].toString();
        }
        return cadena;
    }


    public Object get(int index){
        if(index >= count || index < 0){
            return null;
        }
        return elementos[index];
    }

    @Override
    public Iterator iterator(){
        return new ListaArrayIterador();
    }

    private  class ListaArrayIterador implements Iterator{
        private int posicion = 0;
        @Override
        public boolean hasNext(){
            return posicion < count;
        }
        @Override
        public Object next(){
            return elementos[posicion++];
        }

        
    }
    
}