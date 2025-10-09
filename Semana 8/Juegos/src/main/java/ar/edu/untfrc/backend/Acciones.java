package ar.edu.untfrc.backend;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import ar.edu.untfrc.backend.entities.Juego;
import ar.edu.untfrc.backend.menu.ApplicationContext;
import ar.edu.untfrc.backend.services.DesarrolladorService;
import ar.edu.untfrc.backend.services.GeneroService;
import ar.edu.untfrc.backend.services.JuegoService;


public class Acciones {
    public void importarCsv(ApplicationContext context) {
    var service = context.getService(JuegoService.class);
    
    try (var stream = App.class.getResourceAsStream("/files/juegos.csv")) {
        if (stream == null) {
            System.out.println("No se encontró el CSV en /files");
            return;
        }

        // Guardamos temporalmente en un archivo para que bulkInsert lo lea
        File tempFile = File.createTempFile("juegos", ".csv");
        tempFile.deleteOnExit();
        Files.copy(stream, tempFile.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);

        service.bulkInsert(tempFile);
        var juegos = service.getAllJuegos();

    System.out.println(juegos.size() + " juegos importados:");

        System.out.println("Importación finalizada!");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public void verJuegos(ApplicationContext context) {
    var service = context.getService(JuegoService.class);
    var juegos = service.getAllJuegos();

    System.out.println(juegos.size() + " juegos encontrados:");
    if (juegos.isEmpty()) {
        System.out.println("No hay juegos disponibles.");
    } else {
        juegos.forEach(juego -> {
            if (juego.getGenero() == null || juego.getGenero().getNombre() == null) {
                System.out.println(juego.getTitulo());
            }
        });
    }
}

    public void determinarRanking(ApplicationContext context) {
        var servicio = context.getService(GeneroService.class);
        Map<String, Integer> ranking = servicio.getCantidadJuegosPorGenero();
        if (ranking.isEmpty()) {
            System.out.println("No hay géneros disponibles.");
        } else {
            System.out.println("Ranking de géneros más jugados:");
            ranking.forEach((genero, cantidad) -> 
                System.out.println("Género: " + genero + " - Total Jugando: " + cantidad));
        }
    }

    public void juegosPorDesarrollador(ApplicationContext context){
        var servicio = context.getService(DesarrolladorService.class);
        Map<String, Integer> resultado = servicio.getCantidadJuegosPorDesarrollador();
        if (resultado.isEmpty()) {
            System.out.println("No hay desarrolladores disponibles.");
        } else {
            System.out.println("Lista de desarrolladores:");
            resultado.forEach((desarrollador, cantidad) -> 
                System.out.println("Desarrollador: " + desarrollador + " -Juegos: " + cantidad));
        }
    }

   public void mejorDesarrollador(ApplicationContext context) {
    var servicio = context.getService(DesarrolladorService.class);
    var mejor = servicio.getMejorDesarrollador();

    if (mejor == null) {        
        System.out.println("No hay desarrolladores disponibles.");
    } else {
        System.out.println("Mejor desarrollador:");
        System.out.println("Desarrollador: " + mejor.getNombre());

        double promedio = mejor.getJuegos().stream()
            .filter(j -> j != null && j.getRating() != null) // evita NPE
            .mapToDouble(Juego::getRating)
            .average()
            .orElse(0.0);

        System.out.printf("Promedio de rating: %.2f\n", promedio);
    }
}
}

