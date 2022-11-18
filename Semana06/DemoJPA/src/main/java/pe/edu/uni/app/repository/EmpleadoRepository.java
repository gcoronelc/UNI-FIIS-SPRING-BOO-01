package pe.edu.uni.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.uni.app.model.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

	List<Empleado> findByNombreAndApellido(String nombre, String apellido);

	List<Empleado> findByNombreLike(String nombre);

	List<Empleado> findByNombreContaining(String nombre);

	Empleado buscarPorEmail(String email);

	@Query("select e from Empleado e where e.id = ?1")
	Empleado buscarPorId(Long id);

	@Query("select e from Empleado e where e.nombre like %?1%")
	List<Empleado> buscarPorNombre(String nombre);

	@Query(value = "SELECT * FROM EMPLEADO WHERE nombre LIKE %?1% "
			+ " AND apellido LIKE %?2%", nativeQuery = true)
	List<Empleado> buscarEmpleados(String nombre, String apellido);
}
