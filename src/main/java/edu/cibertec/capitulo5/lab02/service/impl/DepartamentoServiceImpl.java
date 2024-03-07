package edu.cibertec.capitulo5.lab02.service.impl;

import edu.cibertec.capitulo5.lab02.model.Departamento;
import edu.cibertec.capitulo5.lab02.repository.DepartamentoRepository;
import edu.cibertec.capitulo5.lab02.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> listarDepartamentos() {
        return (List<Departamento>) departamentoRepository.findAll();
    }


}
