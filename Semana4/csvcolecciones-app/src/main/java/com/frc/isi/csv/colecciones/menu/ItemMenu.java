package com.frc.isi.csv.colecciones.menu;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class ItemMenu<T> {
    private int codigo;
    private String descripcion;
    private OpcionDeMenu<T> action;
    
    @Override
    public String toString(){
        return this.codigo + "-----------" + this.descripcion;
    }
}
