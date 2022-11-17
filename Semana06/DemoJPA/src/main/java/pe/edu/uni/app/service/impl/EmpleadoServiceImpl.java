package pe.edu.uni.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.uni.app.model.Empleado;
import pe.edu.uni.app.repository.EmpleadoRepository;
import pe.edu.uni.app.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public List<Empleado> listarTodos() {
		return (List<Empleado>) empleadoRepository.findAll();
	}

	@Override
	public Empleado buscarPorId(Long id) {
		return empleadoRepository.findById(id).orElse(null);
	}

	@Override
	public Empleado grabar(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	@Override
	public void eliminar(Long id) {
		empleadoRepository.deleteById(id);
	}

}
