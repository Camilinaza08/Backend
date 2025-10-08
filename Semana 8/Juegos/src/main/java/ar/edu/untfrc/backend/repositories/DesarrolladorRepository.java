package ar.edu.untfrc.backend.repositories;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ar.edu.untfrc.backend.entities.Desarrollador;

public class DesarrolladorRepository extends Repository<Desarrollador, Integer> {
    
    public DesarrolladorRepository(){
        super();
    }

    @Override
    public Desarrollador getById(Integer id){
        return this.manager.find(Desarrollador.class, id);
    }

    @Override
    public Set<Desarrollador> getAll() {
        return this.manager.createQuery("SELECT d FROM Desarrollador d", Desarrollador.class)
                .getResultList()
                .stream().collect(Collectors.toSet());
    }

    @Override
    public Stream<Desarrollador> getAllStream() {
        return this.manager.createQuery("SELECT d FROM Desarrollador d", Desarrollador.class).getResultStream();
    }

}
