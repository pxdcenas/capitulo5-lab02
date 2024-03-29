package edu.cibertec.capitulo5.lab02.service;

import edu.cibertec.capitulo5.lab02.dto.EmpleadoDTO;
import edu.cibertec.capitulo5.lab02.model.Empleado;

import java.util.List;

public interface EmpleadoService {

	List<Empleado> listarEmpleados();

	Empleado registrarEmpleado(Empleado empleado);

	Empleado actualizarEmpleado(Empleado empleado);

	EmpleadoDTO buscarEmpleado(Long id);

	void eliminarEmpleado(Long id);
}
