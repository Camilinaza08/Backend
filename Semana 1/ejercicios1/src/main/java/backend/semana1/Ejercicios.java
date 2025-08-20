package backend.semana1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicios {
    public static void main(String[] args){
        int op;
        do { 
            menu();
            System.out.println("Seleccione su opción");
            op = leerEnteros();
            switch (op) {
                case 1 :
                    ejercicio1();
                    break;
                case 2 :
                    ejercicio2();
                    break;
                case 3 :
                    ejercicio3();
                    break;
                case 4 :
                    ejercicio4();
                    break;
                case 5 :
                    ejercicio5();
                    break;
                case 6 :
                    ejercicio6();
                    break;
                case 0:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Seleccionó una opción fuera de rango");
            }
        } while (op != 0);
        
    }

    private static void menu(){
        System.out.println("Opción 1: Ciclo For");
        System.out.println("Opción 2: Problema ISBN");
        System.out.println("Opción 3: Divisores y Multiplos");
        System.out.println("Opción 4: Productividad");
        System.out.println("Opción 5: Estadisticas con Input");
        System.out.println("Opción 6: Estadisticas con archivo de texto");
        System.out.println("Opción 0: Salir");
    }

     private static int leerEnteros(){
        int num;
        Scanner teclado = new Scanner(System.in);
        num = teclado.nextInt();
        return num;
    };

    private static void ejercicio1(){
        char asterisco = '*';
        char espacio = ' ';

        System.out.println("Figura 1");
        for (int i = 0; i < 4; i++) {
            System.out.println(espacio);
            for (int j = 0; j < 6; j++) {
                System.out.print(asterisco);
                System.out.print(espacio);
            }
        }
        System.out.println(espacio);
        System.out.println("Figura 2");
        for (int i = 0; i < 2; i++) {
            System.out.println(espacio);
            for (int j = 0; j < 6; j++) {
                System.out.print(asterisco);
                System.out.print(espacio);
            }
            System.out.println(espacio);
            for (int j = 0; j < 6; j++) {
                System.out.print(espacio);
                System.out.print(asterisco);
            }
        }

        int k = 0;
        System.out.println(espacio);
        System.out.println("Figura 3");
        for (int i = 0; i < 5; i++) {
            System.out.println(espacio);
            k = k + 1;
            for (int j = 0; j < k; j++) {
                System.out.print(asterisco);
                System.out.print(espacio);
            }
        }

        k = 0;
        System.out.println(espacio);
        System.out.println("Figura 4");
        for (int i = 0; i < 5; i++) {
            System.out.println(espacio);
            k = k + 1;
            for (int j = 0; j < k; j++) {
                System.out.print(asterisco);
                System.out.print(espacio);
            }
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(espacio);
            k = k - 1;
            for (int j = 0; j < k; j++) {
                System.out.print(asterisco);
                System.out.print(espacio);
            }
        }
        System.out.println(" ");
    };

    private static void ejercicio2(){
        int acumulador = 0;
        int contador = 10;
        System.out.println("Ingrese su código: ");
        String codigo = leerCadenas();
        for (int i = 0; i < codigo.length(); i++) {
            char c = codigo.charAt(i);
            //System.out.println("Estoy dentro del for");
            if(esNumero(c)){
                int num = Integer.parseInt(String.valueOf(c));
                acumulador = acumulador + num * contador;
                contador = contador -1;
            }
            
        }
        if(acumulador % 11 == 0){
            System.out.println("Código válido");
        }
        else{
            System.out.println("Código inválido");
        }


    }

    private static String leerCadenas(){
        String cadena;
        Scanner teclado = new Scanner(System.in);
        cadena = teclado.nextLine();
        return cadena;   
    }

    private static boolean  esNumero(char c){
        return Character.isDigit(c);
    }
    

    private static void ejercicio3(){
        System.out.println("Ingrese un número");
        int num = leerEnteros();
        while(num <= 0 ){
            System.out.println("Error: el número debe ser mayor a cero");
            System.out.println("Ingrese un número");
            num = leerEnteros();
            
        }
        for (int i = 0; i < num; i++) {
                if(esMultiplo(i, 3) && esMultiplo(i, 5)){
                    continue;
                }
                else{
                    if(esMultiplo(i, 3) || esMultiplo(i, 5)){
                        System.out.println(i);
                    }
                }
            }

    }

    private static boolean esMultiplo(int num, int multiplo){
        return num % multiplo == 0;
    }

    private static void ejercicio4(){
        System.out.println("Ingrese su nombre: ");
        String nombre = leerCadenas();
        System.out.println("Ingrese cantidad de horas trabajadas: ");
        int cantHoras = leerEnteros();
        System.out.println("Ingrese cantidad de tareas completadas: ");
        int cantTareas = leerEnteros();
        int productividad = calcularProductividad(cantHoras, cantTareas);

        System.out.println("");
        System.out.println("Resultados");
        System.out.println("Nombre: " + nombre);
        System.out.println("Cant de Horas: " + cantHoras);
        System.out.println("Cant de Tareas: " + cantTareas);
        System.out.println("Indice de productividad: " + productividad);
    }
    private static int calcularProductividad(int horas, int tareas){
        int acumulador = tareas * 10;
        if(horas > 8){
            acumulador += 5;
        }
        else{
            int diferencia = (8 - horas) * 5;
            acumulador -= diferencia;
        }
        return  acumulador;
    }

    private static void ejercicio5(){
        int nota = 0;
        int maxima = 0;
        int minima = 11;
        int contador = 0;
        int acumulador = 0;
        int aprobados = 0;
        int desaprobados = 0;
        while(nota != -1){
            System.out.println("Ingrese su nota entre 0 y 10");
            nota = leerEnteros();
            if(nota < 0 || nota > 10){
                if(nota != -1){
                System.out.println("Nota errónea");}
            }
            else{
                if(nota > maxima){
                    maxima = nota;
                }
                if(nota < minima){
                    minima = nota;
                }
                contador += 1;
                acumulador += nota;
                if(nota >= 6){
                    aprobados += 1;
                }
                else{
                    desaprobados += 1;
                }
            }
        }
        float promedio = calcularPromedio(contador, acumulador);
        System.out.println("Nota máxima: " + maxima);
        System.out.println("Nota mínima: " + minima);
        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Desaprobados" + desaprobados);
    }

    private static float calcularPromedio(int contador, int acumulador){
        if(contador > 0){
            return (float)acumulador/contador;
        }
        return 0;
    }

    private static void ejercicio6(){

        int cantNum = 0;
        int cantLineasNoValidas = 0;
        int acumulador = 0;
        int pares = 0;
        int impares = 0;
        File f = new File("src/main/resorces/numeros.txt");
        try(Scanner miEScanner = new Scanner(f)){

        while (miEScanner.hasNextLine()) {
            String elem =  miEScanner.nextLine();
            if(esEntero(elem)){
                cantNum += 1;
                int num = Integer.parseInt(elem);
                acumulador += num;
                if(num % 2 == 0){
                    pares += 1;
                }
                else{
                    impares += 1;
                }
            }
            else{
                cantLineasNoValidas += 1;
            }
        }
        }catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }

        System.out.println("Cantidad números leidos: " + cantNum);
        System.out.println("Cantidad de líneas no válidas: " + cantLineasNoValidas);
        System.out.println("Cantidad de pares: " + pares);
        System.out.println("Cantidad de impares: " + impares);
        float promedio = calcularPromedio(cantNum, acumulador);
        System.out.println("Promedio: " + promedio);
    }

    private static boolean esEntero(String s){
         try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}