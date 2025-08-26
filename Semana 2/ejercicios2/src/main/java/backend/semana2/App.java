package backend.semana2;
import backend.semana2.abstracciones.Fraccionario;
import backend.semana2.abstracciones.ProcesadorFracciones;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Fraccionario frac1 = new Fraccionario();

        var num = (int) (Math.random() * 100) + 1;
        var den = (int) (Math.random() * 100) + 1;

        Fraccionario frac2 = new Fraccionario(num, den);

        System.out.println(frac1.toString());
        System.out.println(frac2.toString());

        num = (int) (Math.random() * 100) + 1;
        den = (int) (Math.random() * 100) + 1;

        frac1.setDenominador(den);
        frac1.setNumerador(num);

        System.out.println(frac1.toString());

        Fraccionario suma = frac1.suma(frac2);
        System.out.println(suma);

        Fraccionario resta = frac1.resta(frac2);
        System.out.println(resta);

        Fraccionario multiplicacion = frac1.multiplicacion(frac2);
        System.out.println(multiplicacion);

        int tam = (int) ((Math.random()*21)+1);
        ProcesadorFracciones process = new ProcesadorFracciones(tam);
        
        for (int i = 0; i < tam; i++) {
            int num1 = (int) (Math.random() * 100) + 1;
            int den1 = (int) (Math.random() * 100) + 1;
            Fraccionario frac = new Fraccionario(num1, den1);
            process.addFraccionario(frac);
        }
        System.out.println(process.toString());
        Fraccionario promedio = new Fraccionario();
        promedio = process.promedio();

        System.out.println(promedio.toString());
    }

}
