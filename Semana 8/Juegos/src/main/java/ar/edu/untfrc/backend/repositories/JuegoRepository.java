package ar.edu.untfrc.backend.repositories;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ar.edu.untfrc.backend.entities.Juego;

public class JuegoRepository extends Repository<Juego, Integer> {
    
    public JuegoRepository(){
        super();
    }

    @Override
    public Juego getById(Integer id){
        return this.manager.find(Juego.class, id);
    }

    @Override
    public Set<Juego> getAll() {
        return this.manager.createQuery("SELECT j FROM Juego j", Juego.class)
                .getResultList()
                .stream().collect(Collectors.toSet());
    }

    @Override
    public Stream<Juego> getAllStream() {
        return this.manager.createQuery("SELECT j FROM Juego j", Juego.class).getResultStream();
    }

    @Override
    public boolean existeByNombreOrDescripcion(String valor) {
        return this.manager.createQuery("SELECT j FROM Juego j WHERE j.titulo = :titulo")
                .setParameter("titulo", valor)
                .getResultStream()
                .findAny()
                .isPresent();
    }




}