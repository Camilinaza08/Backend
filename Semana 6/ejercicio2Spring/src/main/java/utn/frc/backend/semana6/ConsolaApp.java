package utn.frc.backend.semana6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsolaApp implements CommandLineRunner {

		private final SaludoService saludoService;
		
		@Autowired
		private DespedidaService despedidaService;

		public ConsolaApp(SaludoService saludoService){
			this.saludoService = saludoService;
		}

		@Override
		public void run(String...args){
			saludoService.saludar();
			despedidaService.despedir();
		}

		public static void main(String[] args) {
			SpringApplication.run(ConsolaApp.class, args);
		}
	}


