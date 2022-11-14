package pe.edu.uni.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.uni.eureka.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String> {

}
