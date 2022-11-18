package pe.edu.uni.app.service;

import java.util.List;

import pe.edu.uni.app.model.Empleado;

public interface EmpleadoService {

	List<Empleado> listarTodos();

	Empleado buscarPorId(Long id);

	Empleado grabar(Empleado empleado);

	void eliminar(Long id);

	List<Empleado> findByNombreLike(String nombre);

	List<Empleado> findByNombreContaining(String nombre);

	Empleado buscarPorEmail(String email);
	
	List<Empleado> buscarPorNombre(String nombre);
	
	List<Empleado> buscarEmpleados(String nombre, String apellido);
}
