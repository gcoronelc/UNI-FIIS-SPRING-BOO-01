package pe.edu.uni.eureka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.uni.eureka.model.Cliente;
import pe.edu.uni.eureka.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente insertar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	
}
