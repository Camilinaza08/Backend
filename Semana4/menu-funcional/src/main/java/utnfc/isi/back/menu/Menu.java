package utnfc.isi.back.menu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Menu {
    private final MenuOption[] opciones;
    private final String titulo;

    public Menu(String titulo, MenuOption[] opciones) {
        this.titulo = titulo;
        // Ordenar por code al construir el menú
        this.opciones = Arrays.copyOf(opciones, opciones.length);
        Arrays.sort(this.opciones, Comparator.comparingInt(MenuOption::getCode));
    }

    public void run(ApplicationContext ctx) {
        Scanner teclado = new Scanner(System.in);
        ctx.put("in", teclado);
        int opcion = -1;

        do {
            System.out.println("\n== " + titulo + " ==");
            for (MenuOption opt : opciones) {
                System.out.println("Opción " + opt.getCode() + ": " + opt.getLabel());
            }
            System.out.println("Opción 0: Salir");

            System.out.print("Ingrese su opción: ");
            String entrada = teclado.nextLine();

            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                continue;
            }

            if (opcion == 0) {
                System.out.println("Saliendo...");
                break;
            }

            MenuOption seleccionada = buscarOpcion(opcion);
            if (seleccionada != null) {
                seleccionada.action().run(ctx);
            } else {
                System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private MenuOption buscarOpcion(int code) {
        for (MenuOption opt : opciones) {
            if (opt.getCode() == code) {
                return opt;
            }
        }
        return null;
    }
}

 
 

