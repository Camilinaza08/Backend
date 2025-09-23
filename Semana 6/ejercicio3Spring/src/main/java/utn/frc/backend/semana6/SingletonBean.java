package utn.frc.backend.semana6;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonBean {
    public SingletonBean(){
    System.out.println("SingletonBean creado");
    }

    public void mensaje(){
        System.out.println("Método de SingletonBean");
    }
}
