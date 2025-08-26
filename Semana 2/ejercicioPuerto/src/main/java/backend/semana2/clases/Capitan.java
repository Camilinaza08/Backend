package backend.semana2.clases;

public class Capitan {
    private String identificador;
    private String nombre;
    private String apellido;
    private int antiguedad;


    // Creador
    public Capitan(String id, String nom, String ape, int anti ){
        identificador= id;
        nombre = nom;
        apellido = ape;
        antiguedad = anti;
    }

    //Setters
    public void setIdentificador(String id){
        identificador = id;      
    }
    public void setNombre(String id){
        nombre = id;      
    }
    public void setApellido(String id){
        apellido = id;      
    }
    public void setAntiguedad(int anti){
        antiguedad = anti;     
    }

    //Getters
    public String getIdentificador(){
        return identificador;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public int getAntiguedad(){
        return antiguedad;
    }

    public String toString(){
        String cadena = "Identificador: " + identificador + ". Nombre: " + nombre;
        cadena += ". Apellido: " + apellido + ". Antigüedad: " + antiguedad;
        return cadena;
    }
}
