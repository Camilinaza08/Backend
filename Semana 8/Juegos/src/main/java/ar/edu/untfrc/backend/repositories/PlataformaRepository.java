package ar.edu.untfrc.backend.repositories;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ar.edu.untfrc.backend.entities.Plataforma;

public class PlataformaRepository extends Repository<Plataforma, Integer> {
    
    public PlataformaRepository(){
        super();
    }

    @Override
    public Plataforma getById(Integer id){
        return this.manager.find(Plataforma.class, id);
    }

    @Override
    public Set<Plataforma> getAll() {
        return this.manager.createQuery("SELECT p FROM Plataforma p", Plataforma.class)
                .getResultList()
                .stream().collect(Collectors.toSet());
    }

    @Override
    public Stream<Plataforma> getAllStream() {
        return this.manager.createQuery("SELECT p FROM Plataforma p", Plataforma.class).getResultStream();
    }

}