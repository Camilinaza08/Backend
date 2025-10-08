package ar.edu.untfrc.backend.services;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import ar.edu.untfrc.backend.entities.Desarrollador;
import ar.edu.untfrc.backend.entities.Juego;
import ar.edu.untfrc.backend.repositories.DesarrolladorRepository;

public class DesarrolladorService {
       private final DesarrolladorRepository desarrolladorRepository;
       private final Map<String, Desarrollador> desarrolladores;

       public DesarrolladorService(){
        desarrolladorRepository = new DesarrolladorRepository();
        desarrolladores = new HashMap<>();
       }

       public Desarrollador getOrCreateDesarrollador(String nombre){
        return this.desarrolladores.computeIfAbsent(nombre, nom -> {
            Desarrollador desarrollador = new Desarrollador();
            desarrollador.setNombre(nom);
            desarrolladorRepository.add(desarrollador);
            return desarrollador;
        });

       }

       public Map<String, Integer> getCantidadJuegosPorDesarrollador() {
    var desarrolladores = this.desarrolladorRepository.getAllStream();

    // Agrupar por nombre y sumar la cantidad de juegos
    Map<String, Integer> resultado = desarrolladores
        .collect(Collectors.toMap(
            d -> d.getNombre(),
            d -> d.getJuegos().size(),
            Integer::sum // en caso de nombres repetidos
        ));

    // Filtrar solo desarrolladores con más de 30 juegos
    resultado.entrySet().removeIf(entry -> entry.getValue() <= 30);

    return resultado;
}

  public Desarrollador getMejorDesarrollador() {
    return this.desarrolladorRepository.getAllStream()
        .filter(d -> d.getJuegos() != null && !d.getJuegos().isEmpty())
        .max(Comparator.comparingDouble(d ->
            d.getJuegos().stream()
                .filter(j -> j != null && j.getRating() != null) // <-- evita NPE
                .mapToDouble(Juego::getRating)
                .average()
                .orElse(0.0)
        ))
        .orElse(null);
}



}
