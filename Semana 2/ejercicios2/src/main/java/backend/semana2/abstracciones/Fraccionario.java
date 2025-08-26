package backend.semana2.abstracciones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor

public class Fraccionario {
    private int numerador;
    private int denominador;

    public Fraccionario suma(Fraccionario otroFraccionario){
        Fraccionario resultado = new Fraccionario();
        resultado.numerador = this.numerador * otroFraccionario.denominador;
        resultado.denominador = this.denominador * otroFraccionario.numerador;
        return resultado;
    }
    public Fraccionario resta(Fraccionario otroFraccionario){
        Fraccionario resultado = new Fraccionario();
        resultado.denominador = this.denominador * otroFraccionario.denominador;
        resultado.numerador = this.numerador * otroFraccionario.denominador - otroFraccionario.numerador * this.denominador;
        return resultado;
    }
    public Fraccionario multiplicacion(Fraccionario otroFraccionario){
        Fraccionario resultado = new Fraccionario();
        resultado.denominador = this.denominador * otroFraccionario.denominador;
        resultado.numerador = this.numerador * otroFraccionario.numerador;
        return resultado;
    }
    

    //public Fraccionario(int num, int deno){
      //  numerador = num;
        //denominador = deno;
    //}

    //public Fraccionario(){
      //  numerador = 0;
        //denominador = 1;
    //}

    //public int getNumerador(){
      //  return numerador;
    //}

    //public int getDenominador(){
      //  return denominador;
    //}

    //public void setNumerador(int num){
      //  numerador = num;
    //}

    //public void setDenominador(int deno){
      //  denominador = deno;
    //}

    //@Override
    //public String toString(){
      //  return "Fraccionario: {Numerador: " + numerador + ", denominador: " + denominador +"}";
    //}

    
}