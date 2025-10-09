
package backend.repositories;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import backend.entities.TarjetaCredito;

public class TarjetaCreditoRepository extends Repository<TarjetaCredito, Integer> {
 
    public TarjetaCreditoRepository(){
        super();
    }

    @Override
    public TarjetaCredito getById(Integer id){
        return this.manager.find(TarjetaCredito.class, id);
    }

    @Override
    public Set<TarjetaCredito> getAll() {
        return this.manager.createQuery("SELECT tj FROM TarjetaCredito tj", TarjetaCredito.class)
                .getResultList()
                .stream().collect(Collectors.toSet());
    }

    @Override
    public Stream<TarjetaCredito> getAllStream() {
        return this.manager.createQuery("SELECT tj FROM TarjetaCredito tj", TarjetaCredito.class).getResultStream();
    }
}