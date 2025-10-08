package ar.edu.untfrc.backend.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import ar.edu.untfrc.backend.entities.ClasificacionEsrb;
import ar.edu.untfrc.backend.entities.Juego;
import ar.edu.untfrc.backend.repositories.JuegoRepository;

public class JuegoService {

    private final JuegoRepository juegoRepository;
    private final GeneroService generoService;
    private final PlataformaService plataformaService;
    private final DesarrolladorService desarrolladorService;

    public JuegoService() {
        juegoRepository = new JuegoRepository();
        generoService = new GeneroService();
        plataformaService = new PlataformaService();
        desarrolladorService = new DesarrolladorService();
    }

    public void bulkInsert(File fileToImport) throws IOException {
        Files.lines(Paths.get(fileToImport.toURI()))
                .skip(1)
                .forEach(linea -> {
                    Juego juego = procesarLinea(linea);
                    if (juego != null) {
                        this.juegoRepository.add(juego);
                    }
                });
    }

    public Juego procesarLinea(String linea) {
    // Split con -1 para conservar campos vacíos
    String[] tokens = linea.split(";", -1);

    // Validar que tenga exactamente 10 columnas
    if (tokens.length != 10) {
        System.out.println("Línea inválida (no tiene 10 campos): " + linea);
        return null;
    }

    Juego juego = new Juego();

    // 1) Título
    juego.setTitulo(tokens[0].trim());

    // 2) Fecha
    long fechaLanzamientoParseada = convertirFecha(tokens[1].trim());
    juego.setFechaLanzamiento((int) fechaLanzamientoParseada);

    // 3) Desarrollador
    String nombreDesarrollador = procesarDesarrollador(tokens[2]);
    if (nombreDesarrollador == null) return null;
    var desarrollador = desarrolladorService.getOrCreateDesarrollador(nombreDesarrollador);
    desarrollador.addJuego(juego);

    // 4) Resumen
    juego.setResumen(tokens[3].trim());

    // 5) Plataforma
    String nombrePlataforma = procesarPlataforma(tokens[4]);
    if (nombrePlataforma != null) {
        var plataforma = plataformaService.getOrCreatePlataforma(nombrePlataforma);
        plataforma.addJuego(juego);
    } else {
        juego.setPlataforma(null);
    }

    // 6) Género
    String nombreGenero = procesarGenero(tokens[5]);
    if (nombreGenero == null)return null;
        var genero = generoService.getOrCreateGenero(nombreGenero);
        genero.addJuego(juego);

    // 7) Rating
    String ratingRaw = tokens[6].trim();
    Double rating = null;
    if (!ratingRaw.equalsIgnoreCase("N/A") && !ratingRaw.isEmpty()) {
        try {
            rating = Double.parseDouble(ratingRaw);
        } catch (NumberFormatException e) {
            System.out.println("Error al parsear el rating: " + ratingRaw);
            return null;
        }
    }
    juego.setRating(rating);

    // 8) Juegos finalizados
    juego.setJuegosFinalizados(parseCantidad(tokens[7]));

    // 9) Jugando
    juego.setJugando(parseCantidad(tokens[8]));

    // 10) Clasificación ESRB
    String esrb = tokens[9].trim();
    juego.setClasificacionESRB(ClasificacionEsrb.fromCodigo(esrb));

    return juego;
}

// Método auxiliar para convertir "4.3K" a entero
private Integer parseCantidad(String valor) {
    if (valor == null || valor.isEmpty() || valor.equalsIgnoreCase("N/A")) return null;
    try {
        double base = Double.parseDouble(valor.replace("K", "").trim());
        return valor.toUpperCase().contains("K") ? (int) (base * 1000) : (int) base;
    } catch (NumberFormatException e) {
        return null;
    }
}

// Fecha
private long convertirFecha(String fechaOriginal){
    SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
    try {
        Date date = formatter.parse(fechaOriginal);
        return date.getTime();
    } catch (ParseException e) {
        System.out.println("Error al parsear la fecha: " + fechaOriginal);
        return 0;
    }
}

// Procesar cadenas de Género, Plataforma y Desarrollador
private String procesarGenero(String tokenGenero) {
    if (tokenGenero == null || tokenGenero.equals("[]") || tokenGenero.isEmpty()) return null;
    return tokenGenero.replace("[", "").replace("]", "").replace("'", "").trim();
}

private String procesarPlataforma(String tokenPlataforma) {
    if (tokenPlataforma == null || tokenPlataforma.equals("[]") || tokenPlataforma.isEmpty()) return null;
    return tokenPlataforma.replace("[", "").replace("]", "").replace("'", "").trim();
}

private String procesarDesarrollador(String tokenDesarrollador) {
    if (tokenDesarrollador == null || tokenDesarrollador.equals("[]") || tokenDesarrollador.isEmpty()) return null;
    return tokenDesarrollador.replace("[", "").replace("]", "").replace("'", "").trim();
}
    public Set<Juego> getAllJuegos() {
        return juegoRepository.getAll();
    }
}
