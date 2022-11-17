package pe.edu.uni.app.service;

import java.util.List;

import pe.edu.uni.app.model.Empleado;

public interface EmpleadoService {

	List<Empleado> listarTodos();

	Empleado buscarPorId(Long id);

	Empleado grabar(Empleado empleado);

	void eliminar(Long id);
}
