package backend.semana2.clases;

public class Cafetera {
    private String marca;
    private String modelo;
    private int capacidadMaxima;
    private int contenidoActual;
    private boolean encendida;
    private int cafesServidos;
    private int temperatura;

    // Control de encendido
    public void encender(){
        encendida = true;
        temperatura = 20;
        contenidoActual = 0;
    }

    public void apagar(){
        encendida = false;
        cafesServidos = 0;
    }

    // Operaciones
    public void cargarAgua(int ml){
        if(encendida){
        contenidoActual += ml;
        if(ml > capacidadMaxima){
            contenidoActual = capacidadMaxima;
        }
        }
    }

    public void calentar(){
        if(encendida){
            temperatura += 40;
            if(temperatura > 100){
                temperatura = 100;
            }
        }
    }

    public boolean servirCafe(){
        if(encendida && contenidoActual >= 100 && temperatura >= 90 ){
            contenidoActual -= 100;
            cafesServidos += 1;
            return true;
        }
        return false;
    }

    public String toString(){
        String estado = "apagada";
        if(encendida){
            estado = "encendida";
        }
        String cadena = "Cafetera " + modelo + " " + marca + " - Agua: ";
        cadena += contenidoActual + "ml, Temperatura: " + temperatura;
        cadena += "°C, Servidos: " + cafesServidos + ", Estado: " + estado;
        return cadena;
    }

    public Cafetera(String mar, String model, int capacidad){
        marca = mar;
        modelo = model;
        capacidadMaxima = capacidad;
        contenidoActual = 0;
        encendida = false;
        cafesServidos = 0;
        temperatura = 0;
    }

}
