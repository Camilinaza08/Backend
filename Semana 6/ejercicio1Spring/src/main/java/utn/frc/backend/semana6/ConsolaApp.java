package utn.frc.backend.semana6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConsolaApp {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		//Inyección de dependencias
		SaludoService saludoService = context.getBean(SaludoService.class);
		saludoService.saludar();

		DespedidaService despedidaService = context.getBean(DespedidaService.class);
		despedidaService.despedir();	
	}

}
