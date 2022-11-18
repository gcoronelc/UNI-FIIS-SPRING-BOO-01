package pe.edu.uni.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.uni.app.model.Empleado;
import pe.edu.uni.app.service.EmpleadoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping({ "/", "/todos" })
	@ResponseBody
	public List<Empleado> listar() {
		List<Empleado> lista = empleadoService.listarTodos();
		return lista;
	}

	@GetMapping({ "/listado" })
	public String listado(Model model) {
		List<Empleado> lista = empleadoService.listarTodos();
		model.addAttribute("lista", lista);
		return "lista";
	}

	@GetMapping("/leer/{id}")
	@ResponseBody
	public Empleado editar(@PathVariable("id") Long codigo) {
		Empleado empleado = empleadoService.buscarPorId(codigo);
		return empleado;
	}

	@GetMapping("/eliminar/{id}")
	@ResponseBody
	public Empleado eliminar(@PathVariable("id") Long id) {
		Empleado empleado = empleadoService.buscarPorId(id);
		empleadoService.eliminar(id);
		return empleado;
	}

	@GetMapping("/formulario")
	public String formulario() {
		return "formulario";
	}
	
	@PostMapping("/grabar")
	@ResponseBody
	public Empleado guardar(@ModelAttribute Empleado empleado) {
		System.err.println(empleado);
		Empleado bean = empleadoService.grabar(empleado);
		return bean;
	}

	@GetMapping("/buscar/{nombre}")
	@ResponseBody
	public List<Empleado> buscarNombre(@PathVariable("nombre") String nombre){
		// return empleadoService.findByNombreLike(nombre + "%");
		// return empleadoService.findByNombreContaining(nombre);
		return empleadoService.buscarPorNombre(nombre);
	}
	
	@GetMapping("/buscarPorEmail")
	@ResponseBody
	public Empleado buscarPorEmail(@RequestParam("email") String email) {
		return empleadoService.buscarPorEmail(email);
	}
	
	@GetMapping("/buscarEmpleados")
	@ResponseBody
	public List<Empleado> buscarEmpleados(String nombre, String apellido){
		return empleadoService.buscarEmpleados(nombre, apellido);
	}
}
