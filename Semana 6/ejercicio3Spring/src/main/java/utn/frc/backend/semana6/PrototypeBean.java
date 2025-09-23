package utn.frc.backend.semana6;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {
    public PrototypeBean(){
        System.out.println("PrototypeBean creado");
    }
    public void mensaje(){
        System.out.println("Método de PrototypeBean");
    }
}
