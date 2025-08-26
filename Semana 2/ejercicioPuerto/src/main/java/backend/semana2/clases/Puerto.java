package backend.semana2.clases;
public class Puerto {
    private Barco[] barcos;
    private int ultimo;

    public Puerto(int tam){
        barcos = new Barco[tam];
        ultimo = 0;
    }

    public void addBarco(Barco barco){
        barcos[ultimo] = barco;
        ultimo += 1;
    }

    public float calcularTotal(){
        float total = 0;
        for (int i = 0; i < barcos.length; i++) {
            float sumador = (float)barcos[i].getPrecioHora() * 15;
            total += sumador;
        }
        return total;
    }

    public void mostrarBarcos(){
        for (int i = 0; i < barcos.length; i++) {
            System.out.println(barcos[i].toString());
        }
    }

    public void listadoCapitanes(){
        for (int i = 0; i < barcos.length; i++) {
            Barco barco = barcos[i];
            Capitan capitan = barco.getCapitan();
            int antiguedad = capitan.getAntiguedad();
            if(antiguedad > 18){
                System.out.println(barco.toString());
            }
        }
    }

    public float calcularCargaPromedioPar(){
        int acumulador = 0;
        int contador = 0;
        for (int i = 0; i < barcos.length; i++) {
            Barco barco = barcos[i];
            int muelle = barco.getMuelle();
            int carga = barco.getCapacidadCarga();
            if(muelle % 2 == 0){
                acumulador += carga;
                contador += 1;
            }
        }
        if(contador != 0){
            return (float) acumulador/contador;
        }
        return 0;
    }


}
