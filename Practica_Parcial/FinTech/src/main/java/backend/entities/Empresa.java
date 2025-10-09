package backend.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor  
@AllArgsConstructor
@Builder    
@Entity
@Table(name= "EMPRESAS")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)         
    private Integer id;

    @Column(name="EMPRESA")
    private String nombre;

    private double comision;

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    @Builder.Default

    private Set<Empleado> empleados = new HashSet<>();


    public void addEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
        empleado.setEmpresa(this);
    }

    
}
