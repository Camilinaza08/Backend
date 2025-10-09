package backend.repositories;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import backend.entities.Empresa;

public class EmpresaRepository extends Repository<Empresa, Integer> {
 
    public EmpresaRepository(){
        super();
    }

    @Override
    public Empresa getById(Integer id){
        return this.manager.find(Empresa.class, id);
    }

    @Override
    public Set<Empresa> getAll() {
        return this.manager.createQuery("SELECT e FROM Empresa e", Empresa.class)
                .getResultList()
                .stream().collect(Collectors.toSet());
    }

    @Override
    public Stream<Empresa> getAllStream() {
        return this.manager.createQuery("SELECT e FROM Empresa e", Empresa.class).getResultStream();
    }
}
