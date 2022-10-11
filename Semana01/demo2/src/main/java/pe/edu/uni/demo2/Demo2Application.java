package pe.edu.uni.demo2;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.uni.demo2.service.MateService;
import pe.edu.uni.demo2.service.MensajeService;

@SpringBootApplication
@RestController
public class Demo2Application {

	@Autowired
	private MateService mateService;
	
	@Inject
	private MensajeService mensajeService;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Esto se pone bueno!!!";
	}
	
	@GetMapping("/sumar")
	public String sumar(int n1, int n2) {
		return "Suma: " + mateService.sumar(n1, n2);
	}
	
	@GetMapping("/saludo")
	public String saludar(String nombre) {
		return mensajeService.saludo(nombre);
	}

}
