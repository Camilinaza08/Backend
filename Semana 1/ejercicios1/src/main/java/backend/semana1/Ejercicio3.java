import java.util.Scanner;

public class Ejercicio3{
    public static void main(String[] args){
        int numero;

        do{
            System.out.println("Ingrese un nùmero mayor a 0: ");
            numero = leerEnteros();
            if(numero <= 0){
                System.out.println("Ingreso un nùmero menor.");
            }
        }
        while (numero <= 0);

        int i=0;
        for(i=1; i < numero; i++){
            if(i % 3 == 0 && i % 5 != 0){
                System.out.println(i);
            }
            else{
               if(i % 5 == 0 && i % 3 != 0){
                System.out.println(i);
            } 
            }
            }


        }
        private static int leerEnteros(){
        int numero;
        Scanner teclado = new Scanner(System.in);
        numero = teclado.nextInt();
        return numero;
    };
    }
