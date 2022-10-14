package pe.edu.uni.demo3.service;

import org.springframework.stereotype.Service;

@Service
public class Mensaje {

	public String getMensaje() {
		return "Hola mundo Spring Boot.";
	}
}
