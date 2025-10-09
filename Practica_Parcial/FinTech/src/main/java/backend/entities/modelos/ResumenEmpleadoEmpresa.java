package backend.entities.modelos;
import backend.entities.Empleado;
import java.util.Set;

public record ResumenEmpleadoEmpresa(Set<Empleado> empleados, Double gastos, Double comision ) {
    
}
