package backend;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;

import backend.entities.modelos.SaldoGastos;
import backend.menu.ApplicationContext;
import backend.services.EmpleadoService;
import backend.services.EmpresaService;
import backend.services.TarjetaCreditoService;

public class Acciones {
     public void importarCsv(ApplicationContext context) {
        var pathToImport = (URL) context.get("path");

        try (var paths = Files.walk(Paths.get(pathToImport.toURI()))) {
            var csvFiles = paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".csv"))
                    .map(path -> path.toFile())
                    .toList();

            csvFiles.stream()
                    .filter(f -> f.getName()
                            .contains("empleados"))
                    .findFirst()
                    .ifPresentOrElse(f -> {
                        var service = context.getService(EmpleadoService.class);
                        try {
                            service.bulkInsert(f);
                            var empleados = service.getAllEmpleados();
                            System.out.println("Importación finaliazada");
                            System.out.println("Cantidad de empleados: " + empleados.size() );

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    },
                            () -> new IllegalArgumentException("Archivo inexistente"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void listarEmpleados(ApplicationContext context) {
        var service = context.getService(EmpleadoService.class);
        var empleados = service.getAllEmpleados();
        System.out.println("Listado de empleados:");
        empleados.forEach(e -> System.out.println(e));
    }

    public void gastosPorTarjeta(ApplicationContext context){
        var servicio = context.getService(TarjetaCreditoService.class);
        Map<String, Double> gastos = servicio.calcularGastosPorTarjeta();

        if (gastos.isEmpty()) {
            System.out.println("No hay tarjetas disponibles.");
        } else {
            System.out.println("Lista de tarjetas:");
            gastos.forEach((tarjeta, gasto) -> 
                System.out.println("Tarjeta: " + tarjeta + " -Gastos: " + gasto));
        }
    }
public void gastosPorEmpresa(ApplicationContext context) {
    var servicio = context.getService(EmpleadoService.class);
    final String salida = "|%50s|%50s|%50s|%15s|%n";

    try (Scanner lector = new Scanner(System.in)) {
        System.out.println("Ingrese nombre de la empresa:");
        String empresa = lector.next();

        try {
            var resultados = servicio.getEmpleadosEmpresa(empresa);

            System.out.println("=========================================================");
            System.out.printf("|%50s|%50s|%50s|%15s|%n", 
                              "Nombre", "Teléfono", "Nro.Cuenta", "Saldo para gastos");

            String lineas = resultados.empleados().stream()
                .map(e -> String.format(salida, 
                        e.getNombreEmpleado(), 
                        e.getTelefonoEmpleado(), 
                        e.getNumeroCuenta(), 
                        e.getSaldoGastos()))
                .collect(Collectors.joining("\n"));
            
            System.out.println(lineas);
            System.out.println("Gastos total: " + resultados.gastos());
            System.out.println("Comision: " + resultados.comision());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public void proximosVencimientos(ApplicationContext context) {
    var servicio = context.getService(EmpleadoService.class);
    final String salida = "|%50s|%50s|%50s|%50s|%n";
    var resultados = servicio.empleadosTarjetasAVencer();
    System.out.println("=========================================================");
            System.out.printf("|%50s|%50s|%50s|%50s|%n", 
                              "Nombre", "Teléfono", "Nro.Cuenta", "Saldo para gastos");
    String lineas = resultados.stream()
                .map(e -> String.format(salida, 
                        e.getNombreEmpleado(), 
                        e.getTelefonoEmpleado(), 
                        e.getNumeroCuenta(), 
                        e.getTarjetaCredito().getNumeroTarjeta()))
                .collect(Collectors.joining("\n"));
    System.out.println(lineas);
            
                            }

    public void mayorYMenorSaldo(ApplicationContext context) {
    var servicio = context.getService(TarjetaCreditoService.class);
    List<SaldoGastos> resultado = servicio.mayorMenorSaldoGasto();

    if (resultado.isEmpty()) {
        System.out.println("No hay tarjetas disponibles.");
    } else {
        System.out.println("Lista de tarjetas:");
        resultado.forEach(sg -> 
            System.out.println("Tarjeta: " + sg.nombre() 
                + " - Mayor Gasto: " + sg.mayor() 
                + " - Menor Gasto: " + sg.menor())
        );
    }
}

}

    


