package ar.edu.untfrc.backend.services;

import java.util.HashMap;
import java.util.Map;

import ar.edu.untfrc.backend.entities.Plataforma;
import ar.edu.untfrc.backend.repositories.PlataformaRepository;

public class PlataformaService {
       private final PlataformaRepository plataformaRepository;
       private final Map<String, Plataforma> plataformas;

       public PlataformaService(){
        plataformaRepository = new PlataformaRepository();
        plataformas = new HashMap<>();
       }

       public Plataforma getOrCreatePlataforma(String nombre){
        return this.plataformas.computeIfAbsent(nombre, nom -> {
            Plataforma plataforma = new Plataforma();
            plataforma.setNombre(nom);
            plataformaRepository.add(plataforma);
            return plataforma;
        });

       }

}