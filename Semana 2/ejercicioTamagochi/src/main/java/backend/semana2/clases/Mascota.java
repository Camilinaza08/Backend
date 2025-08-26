package backend.semana2.clases;
public class Mascota {
    private int energia;
    private int humor;
    private String nombre;
    private boolean despierto;
    private boolean muerto;

    public void setEnergia(int ener){
        energia = ener;
    }

    public void setHumor(int ener){
        humor = ener;
    }

    public void setNombre(String nom){
        nombre = nom;
    }


    public Mascota(String nom){
        energia = 100;
        humor = 5;
        nombre = nom;
        despierto = true;
        muerto = false;
    }

    public int getEnergia(){
        return this.energia;
    }

    public int getHumor(){
        return this.humor;
    }

    public String getNombre(){
        return this.nombre;
    }

    public boolean  comer(){
        if(!muerto && despierto){
        int aumentoEnergia = energia * 10 /100;
        energia += aumentoEnergia;
        if(energia > 100){
            energia = 100;
        }
        if(humor < 5){
            humor += 1;
        }
        return true;
    }
        return false;
    }

    public boolean  beber(){
        if(!muerto && despierto){
        int aumentoEnergia = energia * 5 /100;
        energia += aumentoEnergia;
        if(energia > 100){
            energia = 100;
        }
        if(humor < 5){
            humor += 1;
        }
        return true;
    }
        return false;
    }

    public boolean  correr(){
        if(!muerto && despierto){
        int decrementoEnergia = energia * 35 /100;
        energia -= decrementoEnergia;
        humor -= 2;
        if(energia <= 0 ){
            setMuerto();
        }
        if(humor <= 0){
            dormir();
        }
            return true;
    } return false;

    }

    public boolean  saltar(){
        if(!muerto && despierto){
        int decrementoEnergia = energia * 15 /100;
        energia -= decrementoEnergia;
        humor -= 2;
        if(energia <= 0 ){
            setMuerto();
        }
        if(humor <= 0){
            dormir();
        }
            return true;}
            return false;
    }

    public boolean dormir(){
        if(!muerto && despierto){
        despierto = false;
        energia += 25;
        humor += 2;
        if(energia > 100){
            energia = 100;
        }
        if(humor > 5){
            humor = 5;
        }
        return true;
        }
        return false;
    }

    public void setMuerto(){
        muerto = true;
    }

    public boolean  despertar(){
        if(!muerto){
        despierto = true;
        humor -= 1;
        if(humor <= 0){
            dormir();
        }
            return true;
    }
        return false;
    }

    public String toString(){
        String cadena = "Nombre: " + nombre + ". Energía: " + energia;
        cadena += "Humor: " + humor + "Despierto: " + despierto;
        cadena += "Vivo" + !muerto;
        return cadena;
    }





    


}
