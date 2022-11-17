package pe.edu.uni.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@GetMapping({"/listado" })
	public String listado(Model model) {
		List<Empleado> lista = empleadoService.listarTodos();
		model.addAttribute("lista", lista);
		return "lista";
	}
}
