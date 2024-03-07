package edu.cibertec.capitulo5.lab02.controller;

import edu.cibertec.capitulo5.lab02.model.Empleado;
import edu.cibertec.capitulo5.lab02.service.DepartamentoService;
import edu.cibertec.capitulo5.lab02.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping
	public String listarEmpleados(Model map) {
		map.addAttribute("listarEmpleados", empleadoService.listarEmpleados());
		return "empleados/listar";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/nuevo")
	public String empleadoNuevo(Model map) {
		map.addAttribute("empleado", new Empleado());
		map.addAttribute("listaDepartamentos", departamentoService.listarDepartamentos());
		return "empleados/nuevo";
	}
	
	@PostMapping(value = "/crear")
	public String empleadoCrear(@ModelAttribute("empleado") Empleado empleado) {
		empleadoService.registrarEmpleado(empleado);
		return "redirect:/empleados";
	}
	
	@GetMapping(value = "/editar/{id}")
	public String empleadoEditar(@ModelAttribute("id") Long id, Model map) {
		map.addAttribute("empleado", empleadoService.buscarEmpleado(id));
		map.addAttribute("listaDepartamentos", departamentoService.listarDepartamentos());
		return "empleados/editar";
	}
	
	@PostMapping(value = "/editar")
	public String empleadoActualizar(@ModelAttribute("empleado") Empleado empleado) {
		empleadoService.actualizarEmpleado(empleado);
		return "empleados/editar";
	}
	
	@GetMapping(value = "/eliminar/{id}")
	public String empleadoEliminar(@ModelAttribute("id") Long id) {
		empleadoService.eliminarEmpleado(id);
		return "redirect:/empleados";
	}
}
