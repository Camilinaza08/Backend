package backend.semana2.abstracciones;

import lombok.ToString;

@ToString
public class ProcesadorFracciones {
    private Fraccionario[] numeros;
    private int ultimo; //ultimo indice usado

    public ProcesadorFracciones(){
        numeros = new Fraccionario[10];
        ultimo = 0;
    }

    public ProcesadorFracciones(int tam){
        numeros = new Fraccionario[tam];
        ultimo = 0;
    }

    public Fraccionario promedio(){
        int tam = this.numeros.length;

        if(tam > 0){
            Fraccionario acumulador = this.numeros[0];
            Fraccionario divisor = new Fraccionario(tam, 1);
            Fraccionario resultado = new Fraccionario();
            for(int i = 1; i < tam; i++){
                acumulador = acumulador.suma(this.numeros[i]);
            }
            resultado.setNumerador(acumulador.getNumerador()*divisor.getDenominador());
            resultado.setDenominador(divisor.getNumerador()*divisor.getDenominador());
            return resultado;

        }
        return  new Fraccionario();
    }

    public void addFraccionario(Fraccionario f){
        if(ultimo < numeros.length){
            this.numeros[ultimo] = f;
            ultimo ++;
        }
    }

}
