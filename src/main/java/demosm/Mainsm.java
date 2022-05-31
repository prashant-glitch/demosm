package demosm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.pk.controller"})//to scan the package
public class Mainsm {
	public static void main(String[] args) {
		SpringApplication.run(Mainsm.class, args);
		System.out.println(" hello");
	}
		
	}



	// componentscan is used here but dont know why com.pk.controller is not scanned

