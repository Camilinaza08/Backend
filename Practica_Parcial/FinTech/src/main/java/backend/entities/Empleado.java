package backend.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name= "EMPLEADOS")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)         
    private Integer id;

    @Column(name = "NOMBRE_EMPLEADO", nullable = false)
    private String nombreEmpleado;

    @Column(name="TELEFONO_EMPLEADO")
    private String telefonoEmpleado;

    @Column(name="NUMERO_CUENTA")
    private String numeroCuenta;

    @Column(name="SALDO_GASTOS")
    private double saldoGastos;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "empresaId", referencedColumnName = "id")
    private Empresa empresa;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "tarjetaCreditoId", referencedColumnName = "id")
    private TarjetaCredito tarjetaCredito;

}