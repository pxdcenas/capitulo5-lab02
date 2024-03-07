package edu.cibertec.capitulo5.lab02.mapper;

import edu.cibertec.capitulo5.lab02.dto.EmpleadoDTO;
import edu.cibertec.capitulo5.lab02.model.Empleado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmpleadoMapper {

    @Mapping(source = "id", target = "identificador")
    @Mapping(source = "nombre", target = "name")
    EmpleadoDTO empleadoToEmpleadoDTO(Empleado empleado);
}
