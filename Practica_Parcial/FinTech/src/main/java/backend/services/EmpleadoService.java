package backend.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import backend.entities.Empleado;
import backend.entities.modelos.ResumenEmpleadoEmpresa;
import backend.repositories.EmpleadoRepository;


public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;
    private final EmpresaService empresaService;
    private final TarjetaCreditoService tarjetaCreditoService;

    public EmpleadoService(){
        empleadoRepository = new EmpleadoRepository();
        empresaService = new EmpresaService();
        tarjetaCreditoService = new TarjetaCreditoService();
    }

    public void bulkInsert(File fileToImport) throws IOException {
        Files.lines(Paths.get(fileToImport.toURI()))
                .skip(1)
                .forEach(linea -> {
                    Empleado empleado = procesarLinea(linea);
                    if (empleado != null) {
                        this.empleadoRepository.add(empleado);
                    }
                });
    }

    public Empleado procesarLinea(String linea){
        // Split con -1 para conservar campos vacíos
    String[] tokens = linea.split(",", -1);

    Empleado empleado = new Empleado();

    empleado.setNombreEmpleado(tokens[0]);
    empleado.setTelefonoEmpleado(tokens[1]); 
    empleado.setNumeroCuenta(tokens[2]);
    empleado.setSaldoGastos(Double.parseDouble(tokens[8]));

    //Asignación Empresa
    String nombre = tokens[3];
    Double comision = Double.parseDouble(tokens[4]);
    var empresa = empresaService.getOrCreateEmpresa(nombre, comision);
    empresa.addEmpleado(empleado);

    //Asignacion tarjetaCredito
    String numero = tokens[5];
    String empresaTarj = tokens[6];

    // Procesamiento vencimiento
    YearMonth ym = YearMonth.parse(tokens[7], DateTimeFormatter.ofPattern("MM/yy"));
    LocalDate vencimiento = ym.atEndOfMonth(); // último día del mes
    

    var tarjeta = tarjetaCreditoService.getOrCreateTarjetaCredito(numero, empresaTarj, vencimiento);
    tarjeta.addEmpleado(empleado);

    return empleado;
    }

    public Set<Empleado> getAllEmpleados(){
        return empleadoRepository.getAll();
    }

   public ResumenEmpleadoEmpresa getEmpleadosEmpresa(String nombre) {
    boolean existeEmpresa = empresaService.existeEmpresa(nombre);

    if (!existeEmpresa) {
        throw new IllegalArgumentException("No se encontró la empresa: " + nombre);
    }

    Set<Empleado> empleados = empleadoRepository.getAllStream()
                            .filter(e -> e.getEmpresa().getNombre().equals(nombre))
                            .collect(Collectors.toSet());

    Double gastos = empleados.stream()
                             .mapToDouble(Empleado::getSaldoGastos)
                             .sum();

    Double comisionGeneral = empleados.stream()
                                      .findFirst()
                                      .map(e -> e.getEmpresa().getComision())
                                      .orElse(0.0);

    Double comision = gastos * comisionGeneral;

    return new ResumenEmpleadoEmpresa(empleados, gastos, comision);
}

public Set<Empleado> empleadosTarjetasAVencer(){
    YearMonth ahora = YearMonth.now();
    LocalDate inicio = ahora.atEndOfMonth();
    YearMonth proximo = ahora.plusMonths(1);
    LocalDate fin = proximo.atEndOfMonth();

    Set<Empleado> empleados = empleadoRepository.getAllStream()
        .filter(e -> {
            LocalDate vencimiento = e.getTarjetaCredito().getVencimientoTarjeta();
            return (vencimiento.isAfter(inicio) || vencimiento.isEqual(inicio)) &&
                   (vencimiento.isBefore(fin) || vencimiento.isEqual(fin));
        })
        .sorted((e1, e2) -> e1.getNombreEmpleado()
                          .compareTo(e2.getNombreEmpleado()))
        .collect(Collectors.toCollection(LinkedHashSet::new));
    
    return empleados;
}

}
