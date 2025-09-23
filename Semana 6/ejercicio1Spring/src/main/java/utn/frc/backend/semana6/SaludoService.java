package utn.frc.backend.semana6;
import org.springframework.stereotype.Component;

@Component
public class SaludoService {
    public void saludar(){
        System.out.println("Hola desde Spring");
    }
}
