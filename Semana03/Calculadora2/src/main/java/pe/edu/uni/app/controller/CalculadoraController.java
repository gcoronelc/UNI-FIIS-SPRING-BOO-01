package pe.edu.uni.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.uni.app.service.MateService;

@Controller
public class CalculadoraController {

	@Autowired
	private MateService service;

	@GetMapping("/")
	public String inicio() {
		return "index";
	}

	@PostMapping("/procesar")
	public String procesar(@RequestParam("num1") int numero1,
			@RequestParam("num2")int numero2, 
			@RequestParam("operacion")int operacion, Model model) {
		int resultado = 0;
		String operador="";

		if (operacion == 1) {
			resultado = service.sumar(numero1, numero2);
			operador="+";
		}
		if (operacion == 2) {
			resultado = service.restar(numero1, numero2);
			operador="-";
		}
		if (operacion == 3) {
			resultado = service.multiplicar(numero1, numero2);
			operador="*";
		}
		if (operacion == 4) {
			resultado = service.dividir(numero1, numero2);
			operador="/";
		}
		String cadena = numero1 + operador + numero2 + "=" + resultado;
		model.addAttribute("respuesta", cadena);

		return "index";
	}
}
