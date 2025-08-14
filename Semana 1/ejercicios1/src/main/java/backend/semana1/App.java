package backend.semana1;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // byte, short, int, long => Nùmeros enteros
        // float, double => Nùmeros flotantes
        // char => Caracter
        // String => Cadena
        // boolean => Boleano

        int numero = 12;
        short otronumero;

        // otronumero = (short) numero;
        otronumero = 15;

        // Casteo de datos cuando son del mismo tipo

        float decimal = 1.2f;

        System.out.println(numero);
        System.out.println(decimal);

        if(numero > otronumero){
            System.out.println("El primero nùmero es el mayor");
        }
        else{
            System.out.println("El segundo nùmero es el mayor");
        }

        // Ingresar Nùmeros enteros
        Scanner teclado = new Scanner(System.in);
        int a;
        a = teclado.nextInt();
        System.out.println(a) ;
        teclado.close();

    }
    
}
