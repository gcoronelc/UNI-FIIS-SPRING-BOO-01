package pe.edu.uni.demo2.service;

import javax.inject.Named;

@Named
public class MensajeService {

	public String saludo( String nombre) {
		String texto = "Hola "+ nombre + ", todo bien!!!";
		return texto;
	}
	
}
