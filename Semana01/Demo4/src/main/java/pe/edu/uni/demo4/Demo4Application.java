package pe.edu.uni.demo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pe.edu.uni.demo4.service.Mensaje;

@SpringBootApplication
public class Demo4Application implements CommandLineRunner {

	@Autowired
	private Mensaje mensaje;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Hola mundo.");
		System.out.println(mensaje.getMensaje());
		
		
	}

	

}
