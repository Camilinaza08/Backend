package backend.semana2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import backend.semana2.clases.Barco;
import backend.semana2.clases.Capitan;
import backend.semana2.clases.Puerto;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Puerto puerto = new Puerto(500);
        menu();
        System.out.println("Ingrese una opción");
        int op = leerEnteros();
        while (op != 1){
            switch (op) {
                case 2:
                    procesarArchivo(puerto);
                    break;
                case 3:
                    System.out.println(puerto.calcularTotal());
                    break;
                case 4:
                    puerto.listadoCapitanes();
                    break;
                case 5:
                    System.out.println(puerto.calcularCargaPromedioPar());
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
            menu();
            System.out.println("Ingrese una opción");
            op = leerEnteros();
        }
    }

    public static void  menu(){
        System.out.println("Menú de opciones");
        System.out.println("Opción 2: Procesar archivo");
        System.out.println("Opción 3: Total de precio de barcos");
        System.out.println("Opción 4: Listado barcos");
        System.out.println("Opción 5: Calcular carga promedio");
        System.out.println("Opción 1: Salir");
    }

    public static int leerEnteros(){
        Scanner teclado = new Scanner(System.in);
        int num = teclado.nextInt();
        return num;
    }

    public static void procesarArchivo(Puerto puerto){
        InputStream input = App.class.getClassLoader().getResourceAsStream("barcos.csv");
         if(input == null) {
            System.out.println("No se encontró barcos.csv en resources");
        }
        String line;
        String separador = ",";

         try (BufferedReader br = new BufferedReader(new InputStreamReader(input))){
            boolean primeraLinea = true;
            while ((line = br.readLine()) != null) {
                if (primeraLinea) { // Saltar encabezado
                    primeraLinea = false;
                    System.out.println("Primera linea");
                    continue;
                }

                String[] datos = line.split(separador);

                String matricula = datos[0];
                int muelle = Integer.parseInt(datos[1]);
                int carga = Integer.parseInt(datos[2]);
                float precio = Float.parseFloat(datos[3]);
                String id = datos[4];
                String nombre = datos[5];
                String apellido = datos[6];
                int antiguedad = Integer.parseInt(datos[7]);
               
                Capitan cap = new Capitan(id, nombre, apellido, antiguedad);
                Barco barco = new Barco(matricula, muelle, carga, precio, cap);
                puerto.addBarco(barco);
        }} catch (IOException e) {
            e.printStackTrace();
        }
        puerto.mostrarBarcos();   
    }
}
