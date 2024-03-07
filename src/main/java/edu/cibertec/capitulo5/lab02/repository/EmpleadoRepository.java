package edu.cibertec.capitulo5.lab02.repository;


import edu.cibertec.capitulo5.lab02.model.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

}
