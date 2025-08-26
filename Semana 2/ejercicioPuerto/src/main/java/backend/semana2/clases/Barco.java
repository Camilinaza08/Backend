package backend.semana2.clases;

public class Barco {
     private String matricula;
     private int muelle;
     private int capacidadCarga;
     private float precioHora;
     private Capitan capitan;

    public Barco(String mat, int nro, int capacidad, float precio, Capitan cap) {
        matricula = mat;
        muelle = nro;
        capacidadCarga = capacidad;
        precioHora = precio;
        capitan = cap;
    }

    //Setter
    public void setMatricula(String matri){
        matricula = matri;
    }
    public void setMuelle(int nroMuelle){
        muelle = nroMuelle;
    }
    public void setCapacidad(int capacidad){
        capacidadCarga = capacidad;
    }
    public void setPrecioHora(float precio){
        precioHora = precio;
    }
    public void setCapitan(Capitan cap){
       capitan = cap;
    }

    //Getters
    public String getMatricula(){
        return matricula;
    }
    public int getMuelle(){
        return muelle;
    }
    public int getCapacidadCarga(){
        return capacidadCarga;
    }
    public float getPrecioHora(){
        return precioHora;
    }
    public Capitan getCapitan(){
        return capitan;
    }

    public String toString(){
        String cadena = matricula + "-" + muelle + "-" + capacidadCarga + "- $" + precioHora;
        cadena += capitan.toString();
        return cadena;
    }

     
}
