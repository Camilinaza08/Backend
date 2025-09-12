package com.frc.isi.csv.colecciones.app;

import com.frc.isi.csv.colecciones.clases.Venta;
import com.frc.isi.csv.contexto.ContextoVentas;
import com.frc.isi.csv.colecciones.menu.Menu;
import com.frc.isi.csv.colecciones.menu.OpcionDeMenu;
import java.util.Scanner;



/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ContextoVentas contexto = new ContextoVentas();

        // Crear el menú
        Menu<ContextoVentas> menu = new Menu<>();

        // Opción 1: Agregar una venta
        menu.registrarOpcion(1, "Agregar una nueva venta", ctx -> {
            Scanner sc = new Scanner(System.in);

            Venta venta = new Venta();
            System.out.print("Código: ");
            venta.setCodigo(sc.nextLine());

            System.out.print("Producto: ");
            venta.setProducto(sc.nextLine());

            System.out.print("Cantidad vendida: ");
            venta.setCantidadVendida(sc.nextInt());

            System.out.print("Precio unitario: ");
            venta.setPrecioUnitario(sc.nextDouble());

            System.out.print("Descuento: ");
            venta.setDescuento(sc.nextDouble());

            sc.nextLine(); // limpiar buffer

            // TipoProducto puede ser null o manejado por ID si no usás enum
            // venta.setTipoProducto(...); // omitir o implementar si hace falta

            ctx.agregarVenta(venta);
            System.out.println("✅ Venta agregada correctamente.");
        });

        // Opción 2: Mostrar todas las ventas
        menu.registrarOpcion(2, "Mostrar ventas registradas", ctx -> {
            System.out.println("📦 Ventas registradas:");
            ctx.getVentas().stream()
                    .forEach(System.out::println);
        });

        // Opción 3: Mostrar total de ventas acumulado
        menu.registrarOpcion(3, "Mostrar total acumulado de ventas", ctx -> {
            double total = ctx.getVentas().stream()
                    .mapToDouble(Venta::calcularPrecioVenta)
                    .sum();
            System.out.println("💰 Total acumulado de ventas: $" + total);
        });

        // Opción 0: Salir
        menu.registrarOpcion(0, "Salir del sistema", ctx -> {
            System.out.println("👋 Gracias por usar el sistema.");
        });

        // Ejecutar el menú
        menu.invocarAccion(contexto);
    }
}






