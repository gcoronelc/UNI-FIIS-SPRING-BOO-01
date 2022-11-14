package pe.edu.uni.eureka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.uni.eureka.model.Empleado;
import pe.edu.uni.eureka.repository.EmpleadoRepository;

@Service
public class LogonService {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	public Empleado validar(String usuario, String clave) {
		Empleado bean = empleadoRepository.findByUsuarioAndClave(usuario, clave);
		return bean;
	}
}
