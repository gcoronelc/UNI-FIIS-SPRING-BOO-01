package pe.edu.uni.eureka.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.uni.eureka.service.CuentaService;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {
	
	@Autowired
	private CuentaService cuentaService;

	@GetMapping("/movimientos")
	public String movimientos(Model model) {
		model.addAttribute("accion", 1);
		return "consultarMovimientos";
	}
	
	@PostMapping("/movimientos")
	public String movimientos(@RequestParam("desde") String fecha1, 
			@RequestParam("hasta") String fecha2, Model model) {
		List<Map<String,Object>> lista;
		System.out.println("Fecha1: " + fecha1);
		System.out.println("Fecha2: " + fecha2);
		lista = cuentaService.consultarMovimientos(fecha1, fecha2);
		model.addAttribute("accion", 2);
		model.addAttribute("lista", lista);
		return "consultarMovimientos";
	}
}
