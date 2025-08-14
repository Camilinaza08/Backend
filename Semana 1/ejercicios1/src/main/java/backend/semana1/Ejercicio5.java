import java.util.Scanner;

public class Ejercicio5{
    public static void main(String[] args){
        int nota;
        int max = -1;
        int min = 11;
        int acumulador = 0;
        int contador = 0;
        int aprobados = 0;
        int desaprobados = 0;
        do { 
            System.out.println("Ingrese una nota: ");
            nota = leerEnteros();
            if((nota < 0 || nota > 10) && nota != -1 ){
                System.out.println("Ingresò una nota fuera del rango");
            }
            else {if(nota == -1){
                System.out.println("Resultados:");
            }
            else{
                if(nota < min){
                    min = nota;
                }
                if(nota > max ){
                    max = nota;
                }
                acumulador += nota;
                contador += 1;
                if (nota >= 6){
                    aprobados += 1;
                }
                else{
                    desaprobados += 1;
                }
            }}
        } while (nota != -1);

        float promedio;
        promedio = calcularPromedio(acumulador, contador);
        
        System.out.println("Mìnima nota: " + min);
        System.out.println("Màxima nota: " + max);
        System.out.println("Promedio: " + promedio);
        System.out.println("Cant. Aprobados: " + aprobados);
        System.out.println("Cant. Desaprobados: " + desaprobados);

    }
    private static int leerEnteros(){
        int nota;
        Scanner teclado = new Scanner(System.in);
        nota = teclado.nextInt();
        return nota;
    };
    private static float calcularPromedio(int acumulador, int contador){
        float promedio;
        if(contador == 0){
            promedio = 0;
        }
        else{
            promedio = (float)acumulador / contador;
        }
        return promedio;
    }
}