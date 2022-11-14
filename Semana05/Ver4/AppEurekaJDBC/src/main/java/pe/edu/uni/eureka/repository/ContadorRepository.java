package pe.edu.uni.eureka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.uni.eureka.model.Contador;

@Repository
public interface ContadorRepository extends CrudRepository<Contador, String>{

}
