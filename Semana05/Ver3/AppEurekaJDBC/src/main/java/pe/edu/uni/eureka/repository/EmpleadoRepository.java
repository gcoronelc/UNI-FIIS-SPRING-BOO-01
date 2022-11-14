package pe.edu.uni.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.uni.eureka.model.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, String>{

	
	Empleado findByUsuarioAndClave(String usuario, String clave);
	
	
}
