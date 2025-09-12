package com.frc.isi.csv.colecciones.menu;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Menu<T> implements IMenu<T> {
    private Map<Integer, ItemMenu<T>> acciones = new HashMap<>();
    
    public void registrarOpcion(int opcion, String descripcion, OpcionDeMenu<T> accion){
        acciones.put(opcion, new ItemMenu<>(opcion, descripcion,  accion);
    }

    public void invocarAccion(T contexto){
        int op;
        Scanner teclado = new Scanner(System.in);
        do{
        //Visualizar menù usando ItemMenu
            System.out.println("---------Menù-------");
            acciones.values().stream()
            .sorted((a,b)=> Integer.compare(a.getCodigo(), b.getCodigo()))
            .forEach(System.out::println);
            System.out.println("Ingrese una opcion": );
            op = teclado.nextInt();
        ItemMenu <T> itemSeleccionado = acciones.get(op);
        if(itemSeleccionado != null){
            itemSeleccionado.getAction().ejecutar(contexto);
        }else{
            System.out.println("Opcion vàlida");
        }
        } while(op != 0);
    }
}
