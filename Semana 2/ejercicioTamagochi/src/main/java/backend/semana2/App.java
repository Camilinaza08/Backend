package backend.semana2;
import java.util.Scanner;

import backend.semana2.clases.Mascota;

/**
 * Hello world!
 */
public class App {
 public static void main(String[] args) {
    System.out.println("Comenzemos a crear a nuestra mascota");
    System.out.println("Ingrese su nombre");
    String nombre = ingresarTexto();
    Mascota mas = new Mascota(nombre);
    int op = -1;
    int ingesta = 0;
    int actividad = 0;
    while (op != 0){
        System.out.println("Seleccione una opción");
        System.out.println("Opción 1: Comer");
        System.out.println("Opción 2: Beber");
        System.out.println("Opción 3: Correr");
        System.out.println("Opción 4: Saltar");
        System.out.println("Opción 5: Dormir");
        System.out.println("Opción 6: Despertar");
        System.out.println("Opción 7: Mostrar datos");
        System.out.println("Opción 0: Salir");
        System.out.println("Ingrese su opción: ");
        op = ingresarEnteros();
        switch (op) {
            case 1:
                System.out.println(mas.comer());
                ingesta += 1;
                actividad = 0;
                break;
            case 2:
                System.out.println(mas.beber());
                ingesta += 1;
                actividad = 0;
                break;
            case 3:
                System.out.println(mas.correr());
                ingesta = 0;
                actividad += 1;
                break;
            case 4:
                System.out.println(mas.saltar());
                ingesta = 0;
                actividad += 1;
                break;
            case 5:
                System.out.println(mas.dormir());
                ingesta = 0;
                actividad = 0;
                break;
            case 6:
                System.out.println(mas.despertar());
                ingesta = 0;
                actividad = 0;
                break;
            case 7:
                System.out.println(mas.toString());
                break;
            default:
                System.out.println("Opción incorrecta");
                break;
            
        }
         if(ingesta >= 3){
                int nuevo = mas.getHumor() -1;
                mas.setHumor(nuevo);
            }
            if(ingesta >= 5){
                mas.setMuerto();
            }
            if(actividad >= 3){
                mas.dormir();
            }


    }
    System.out.println(mas.toString());
        System.out.println("Fin del programa");
    
 }

 public static int ingresarEnteros(){
    Scanner teclado = new Scanner(System.in);
    int num = teclado.nextInt();
    return num;
 }

 public static String ingresarTexto(){
    Scanner teclado = new Scanner(System.in);
    String texto = teclado.nextLine();
    return texto;
 }
}

