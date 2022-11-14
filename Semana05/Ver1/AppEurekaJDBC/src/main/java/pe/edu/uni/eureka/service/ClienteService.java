package pe.edu.uni.eureka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.uni.eureka.model.Cliente;
import pe.edu.uni.eureka.model.ClientePersistable;
import pe.edu.uni.eureka.model.Contador;
import pe.edu.uni.eureka.repository.ClientePersistableRepository;
import pe.edu.uni.eureka.repository.ClienteRepository;
import pe.edu.uni.eureka.repository.ContadorRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClientePersistableRepository clientePersistableRepository;
	
	@Autowired
	private ContadorRepository contadorRepository;

	public Cliente insertar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public ClientePersistable insertar2(ClientePersistable cliente) {
		return clientePersistableRepository.save(cliente);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor=Exception.class)
	public ClientePersistable merge(ClientePersistable cliente) {
		if(cliente.isNew()) {
			Contador contador = contadorRepository.findById("Cliente").get();
			int cont = contador.getContador() + 1;
			contador.setContador(cont);
			contadorRepository.save(contador);
			String codigo = String.format("%05d", cont++);
			cliente.setCodigo(codigo);
			
		}
		return clientePersistableRepository.save(cliente);
	}
	
	
}
