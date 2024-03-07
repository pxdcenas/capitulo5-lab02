package edu.cibertec.capitulo5.lab02.service.impl;

import edu.cibertec.capitulo5.lab02.model.Empleado;
import edu.cibertec.capitulo5.lab02.repository.EmpleadoRepository;
import edu.cibertec.capitulo5.lab02.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> listarEmpleados() {
        return (List<Empleado>) empleadoRepository.findAll();
    }

    @Override
    public Empleado registrarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado actualizarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado buscarEmpleado(Long id) {
        return empleadoRepository.findById(id).get();
    }

    @Override
    public void eliminarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}
