package pe.edu.uni.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pe.edu.uni.eureka.model.Cliente;
import pe.edu.uni.eureka.service.ClienteService;

@Controller
public class DemoController {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/prueba01")
	public String prueba01() {
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("99999");
		cliente.setPaterno("Torres");
		cliente.setMaterno("Castro");
		cliente.setNombre("Juan");
		cliente.setDni("12345678");
		cliente.setDireccion("Lima");
		cliente.setCiudad("Lima");
		cliente.setEmail("juan@gmail.com");
		cliente = clienteService.insertar(cliente);
		System.out.println("Código: " + cliente.getCodigo());
		
		return "home";
	}
}
