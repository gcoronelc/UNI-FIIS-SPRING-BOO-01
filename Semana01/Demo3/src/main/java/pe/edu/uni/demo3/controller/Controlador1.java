package pe.edu.uni.demo3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.uni.demo3.service.Mensaje;

@RestController
public class Controlador1 {

	@Autowired
	private Mensaje mensaje;
	
	@GetMapping("/mensaje")
	public String HolaMundo() {
		return mensaje.getMensaje();
	}
}
