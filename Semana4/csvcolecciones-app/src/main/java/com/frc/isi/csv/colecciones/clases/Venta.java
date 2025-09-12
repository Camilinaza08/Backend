package com.frc.isi.csv.colecciones.clases;
import lombok.Data;;
@Data
public class Venta {
    private String codigo;
    private String producto;
    private int cantidadVendida;
    private double precioUnitario;
    private double descuento;
    private TipoProducto tipoProducto;

    public double calcularPrecioVenta(){
        return cantidadVendida * precioUnitario - descuento;
    }
}
