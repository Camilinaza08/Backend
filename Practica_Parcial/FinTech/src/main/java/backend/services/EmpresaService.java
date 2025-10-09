package backend.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import backend.entities.Empresa;
import backend.repositories.EmpresaRepository;

public class EmpresaService {
    private final EmpresaRepository empresaRepository;
    private final Map<String, Empresa> empresas;

    public EmpresaService(){
        empresaRepository = new EmpresaRepository();
        empresas = new HashMap<>();
    }

    public Empresa getOrCreateEmpresa(String nombre, Double comision){
        return this.empresas.computeIfAbsent(nombre, nom -> {
            Empresa empresa = new Empresa();
            empresa.setNombre(nom);
            empresa.setComision(comision);
            empresaRepository.add(empresa);
            return empresa;
        });

       }

   

public Set<Empresa> getTodasEmpresas(){
        return empresaRepository.getAll();
    }

    public boolean existeEmpresa(String nombre){
        return empresaRepository.existeByNombreOrDescripcion(nombre);
    }

}
