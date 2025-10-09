package backend.entities;

import java.time.LocalDate;
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
@Table(name= "TARJETAS_CREDITO")
public class TarjetaCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NUMERO_TARJETA", nullable = false, unique = true)
    private String numeroTarjeta;

    @Column(name = "EMPRESA_TARJETA")
    private String empresaTarjeta;

    @Column(name = "VENCIMIENTO_TARJETA")
    private LocalDate vencimientoTarjeta;

    @OneToMany(mappedBy = "tarjetaCredito", fetch = FetchType.LAZY)
    @Builder.Default

    private Set<Empleado> empleados = new HashSet<>();


    public void addEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
        empleado.setTarjetaCredito(this);
    }
}
