package utn.frc.backend.semana6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ScopeApp implements CommandLineRunner{
	@Autowired
	private ApplicationContext context;
	public static void main(String[] args) {
		SpringApplication.run(ScopeApp.class, args);
	}
	@Override
	public void run(String...args){
		//Obtener el bean con singleton
		System.out.println("Probando Singleton Scope");
		SingletonBean singletonBean1 = context.getBean(SingletonBean.class);
		SingletonBean singletonBean2 = context.getBean(SingletonBean.class);

		System.out.println("¿Es el mismo bean? " + (singletonBean1 == singletonBean2));

		//Obtener el bean con prototype
		System.out.println("Probando Prototype Scope");
		PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);
		PrototypeBean prototypeBean2 = context.getBean(PrototypeBean.class);

		System.out.println("¿Es el mismo bean? " + (prototypeBean1 == prototypeBean2));

		
	}

}
