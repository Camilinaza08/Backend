package backend.semana2;

import java.util.Scanner;

import backend.semana2.clases.Cafetera;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int op;
        System.out.println("Vamos a cargar los datos de la cafetera");
        System.out.println("Ingrese el modelo");
        String modelo = leerCadenas();
        System.out.println("Ingrese la marca");
        String marca = leerCadenas();
        System.out.println("Ingrese la capacidad máxima");
        int capacidad = leerEnteros();
        Cafetera cafe1 = new Cafetera(marca, modelo, capacidad);
        menu();
        op = leerEnteros();
        while(op != 0){
            switch (op) {
                case 1 :
                    cafe1.encender();
                    break;
                case 2 :
                    cafe1.apagar();
                    break;
                case 3 :
                System.out.println("Ingrese ml:");
                int ml = leerEnteros();
                    cafe1.cargarAgua(ml);
                    break;
                case 4:
                    cafe1.calentar();
                    break;
                case 5:
                    System.out.println(cafe1.servirCafe());
                    break;
                case 6:
                    System.out.println(cafe1.toString());
                default:
                    System.out.println("Opción incorrecta");
            }
            menu();
            op = leerEnteros();
        }
    }

    public static void menu(){
        System.out.println("Menú de opciones");
        System.out.println("Opción 1: encender");
        System.out.println("Opción 2: apagar");
        System.out.println("Opción 3: cargarAgua");
        System.out.println("Opción 4: calentar");
        System.out.println("Opción 5: servir Cafe");
        System.out.println("Opción 6: mostrar Datos");
        System.out.println("Opción 0: Salir");
        System.out.println("Ingrese una opción");
    }

    public static int leerEnteros(){
        Scanner teclado = new Scanner(System.in);
        int num = teclado.nextInt();
        return num;
    }

    public static String leerCadenas(){
        Scanner teclado = new Scanner(System.in);
        String cadena = teclado.nextLine();
        return cadena;
    }
}
