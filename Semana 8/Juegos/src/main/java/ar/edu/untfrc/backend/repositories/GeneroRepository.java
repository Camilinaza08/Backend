package ar.edu.untfrc.backend.repositories;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ar.edu.untfrc.backend.entities.Genero;

public class GeneroRepository extends Repository<Genero, Integer> {
    
    public GeneroRepository(){
        super();
    }

    @Override
    public Genero getById(Integer id){
        return this.manager.find(Genero.class, id);
    }

    @Override
    public Set<Genero> getAll() {
        return this.manager.createQuery("SELECT g FROM Genero g", Genero.class)
                .getResultList()
                .stream().collect(Collectors.toSet());
    }

    @Override
    public Stream<Genero> getAllStream() {
        return this.manager.createQuery("SELECT g FROM Genero g", Genero.class).getResultStream();
    }

}
