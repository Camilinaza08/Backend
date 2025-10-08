package ar.edu.untfrc.backend;

import java.net.URL;

import ar.edu.untfrc.backend.menu.ApplicationContext;
import ar.edu.untfrc.backend.menu.ItemMenu;
import ar.edu.untfrc.backend.menu.Menu;
import ar.edu.untfrc.backend.services.DesarrolladorService;
import ar.edu.untfrc.backend.services.GeneroService;
import ar.edu.untfrc.backend.services.JuegoService;

/**
 * Clase principal para ejecutar la aplicación de gestión de juegos
 */
public class App {
    public static void main(String[] args) {
        // Obtener instancia del contexto
        var ctx = ApplicationContext.getInstance();

        // Crear menú y setear título
        Menu menu = new Menu();
        menu.setTitulo("Menú de Opciones de Juegos");

        // Instancia de acciones
        Acciones acciones = new Acciones();

        // Obtener carpeta "files" desde recursos
        URL folderPath = App.class.getResource("/files");

        if (folderPath == null) {
            System.out.println("No se encontró la carpeta /files en src/main/resources");
            System.out.println("Por favor crea la carpeta y coloca tus CSV ahí.");
        }

        // Guardar la ruta en el ApplicationContext
        ctx.put("path", folderPath);

        // Registrar los servicios
        ctx.registerService(JuegoService.class, new JuegoService());
        ctx.registerService(GeneroService.class, new GeneroService());
        ctx.registerService(DesarrolladorService.class, new DesarrolladorService());

        // Agregar opciones al menú
        menu.addOpcion(new ItemMenu(1, "Importar juegos desde CSV", acciones::importarCsv));
        menu.addOpcion(new ItemMenu(2, "Determinar ranking géneros más jugados", acciones::determinarRanking));
        menu.addOpcion(new ItemMenu(3, "Ver juegos por desarrollador", acciones::juegosPorDesarrollador));
        menu.addOpcion(new ItemMenu(4, "Mejor desarrollador", acciones::mejorDesarrollador));

        // Ejecutar el menú
        menu.ejecutar(ctx);
    }
}

