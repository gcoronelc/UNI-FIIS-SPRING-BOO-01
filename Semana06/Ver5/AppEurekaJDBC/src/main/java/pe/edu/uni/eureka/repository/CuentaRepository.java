package pe.edu.uni.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.uni.eureka.model.Cuenta;

@Repository
public interface CuentaRepository extends CrudRepository<Cuenta, String>{

}
