package backend.services;

import backend.repositories.TarjetaCreditoRepository;
import backend.entities.TarjetaCredito;
import backend.entities.Empleado;
import backend.entities.modelos.SaldoGastos;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class TarjetaCreditoService {
    private final TarjetaCreditoRepository tarjetaCreditoRepository;
    private final Map<String, TarjetaCredito> tarjetasCredito;

    public TarjetaCreditoService(){
        tarjetaCreditoRepository = new TarjetaCreditoRepository();
        tarjetasCredito = new HashMap<>();
    }

    public TarjetaCredito getOrCreateTarjetaCredito(String numero, String empresa, LocalDate vencimiento){
        return this.tarjetasCredito.computeIfAbsent(numero, num -> {
            TarjetaCredito tarjeta = new TarjetaCredito();
            tarjeta.setNumeroTarjeta(num);
            tarjeta.setEmpresaTarjeta(empresa);
            tarjeta.setVencimientoTarjeta(vencimiento);
            tarjetaCreditoRepository.add(tarjeta);
            return tarjeta;
        });

       }
    
   public Map<String, Double> calcularGastosPorTarjeta() {
    var tarjetas = this.tarjetaCreditoRepository.getAllStream();

    // Sumar gastos de tarjetas de la misma empresa
    Map<String, Double> gastos = tarjetas
        .collect(Collectors.toMap(
            t -> t.getEmpresaTarjeta(),
            t -> t.getEmpleados().stream()
                  .mapToDouble(Empleado::getSaldoGastos)
                  .sum(),
            Double::sum // merge function para claves duplicadas
        ));

    // Ordenar por valor ascendente
    Map<String, Double> gastosOrdenados = gastos.entrySet().stream()
        .sorted(Map.Entry.<String, Double>comparingByValue())
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (a, b) -> a,
            LinkedHashMap::new
        ));

    return gastosOrdenados;
}

public List<SaldoGastos> mayorMenorSaldoGasto() {

    return tarjetaCreditoRepository.getAllStream()
        .collect(Collectors.groupingBy(
            TarjetaCredito::getEmpresaTarjeta
        ))
        .entrySet().stream()
        .map(entry -> {
            String nombre = entry.getKey();
            List<Empleado> empleados = entry.getValue().stream()
                                         .flatMap(t -> t.getEmpleados().stream())
                                         .toList();

            double mayor = empleados.stream()
                                    .mapToDouble(Empleado::getSaldoGastos)
                                    .max()
                                    .orElse(0.0);

            double menor = empleados.stream()
                                    .mapToDouble(Empleado::getSaldoGastos)
                                    .min()
                                    .orElse(0.0);

            return new SaldoGastos(nombre, mayor, menor);
        })
        .collect(Collectors.toList());
}


}


