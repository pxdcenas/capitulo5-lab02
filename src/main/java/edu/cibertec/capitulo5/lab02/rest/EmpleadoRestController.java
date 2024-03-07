package edu.cibertec.capitulo5.lab02.rest;

import edu.cibertec.capitulo5.lab02.model.Empleado;
import edu.cibertec.capitulo5.lab02.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleadosrest")
public class EmpleadoRestController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<Empleado>> listarEmpleados() {
        return ResponseEntity.ok(empleadoService.listarEmpleados());
    }

    @PostMapping
    public ResponseEntity<Empleado> registrarEmpleado(@RequestBody Empleado empleado) {
        return ResponseEntity.ok(empleadoService.registrarEmpleado(empleado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        empleado.setId(id);
        return ResponseEntity.ok(empleadoService.actualizarEmpleado(empleado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscarEmpleado(@PathVariable Long id) {
        return ResponseEntity.ok(empleadoService.buscarEmpleado(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id) {
        empleadoService.eliminarEmpleado(id);
        return ResponseEntity.noContent().build();
    }
}
