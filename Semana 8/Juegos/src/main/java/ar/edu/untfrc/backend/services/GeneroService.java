package ar.edu.untfrc.backend.services;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import ar.edu.untfrc.backend.entities.Genero;
import ar.edu.untfrc.backend.entities.Juego;
import ar.edu.untfrc.backend.repositories.GeneroRepository;

public class GeneroService {
       private final GeneroRepository generoRepository;
       private final Map<String, Genero> generos;

       public GeneroService(){
        generoRepository = new GeneroRepository();
        generos = new HashMap<>();
       }

       public Genero getOrCreateGenero(String nombre){
        return this.generos.computeIfAbsent(nombre, nom -> {
            Genero genero = new Genero();
            genero.setNombre(nom);
            generoRepository.add(genero);
            return genero;
        });

       }

       public Map<String, Integer> getCantidadJuegosPorGenero() {
        return this.generoRepository.getAllStream()
            .collect(Collectors.toMap(
                g -> g.getNombre(), // clave: nombre del género
                g -> g.getJuegos().stream()
                        .mapToInt(Juego::getJugando) // tomamos el "jugando" de cada juego
                        .sum() // sumamos
            ))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) // orden descendente
            .limit(5) // solo los 5 primeros
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (a,b) -> a,
                LinkedHashMap::new // para mantener el orden
            ));
    }


}
