package backend.semana3;

import java.util.Iterator;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
                                                                                                   ListaArray lista = new ListaArray(5);

        lista.add(5);
        lista.add(4);
        lista.add(3);
        lista.add(2);
        lista.add(1);

        System.out.println(lista.toString());

        for(int i = 0; i < 50; i++){
            lista.add((int)(Math.random())*1000);
        }

        System.out.println(lista.toString());

        int acu = 0;
        Iterator it = lista.iterator();
        while(it.hasNext()){
            Object elem = it.next();
            acu += (int) elem;
        }

        System.out.println("Promedio: " + (float) acu/lista.size());

        Iterator it2 = lista.iterator();
        for(Obje)
    }
}
