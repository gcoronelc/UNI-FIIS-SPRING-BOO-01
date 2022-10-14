package pe.edu.uni.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.edu.uni.demo.service.MateService;

@Controller
public class HomeController {
	
	@Autowired
	private MateService mateService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("mensaje", "Hola GUSTAVO CORONEL.");
		return "home";
	}

	@GetMapping("/sumar")
	public String sumar() {
		return "sumar";
	}
	
	@PostMapping("/sumar")
	public String sumar(int num1, int num2, Model model) {
		// Proceso
		int suma = mateService.sumar(num1, num2);
		// Reporte
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("suma", suma);
		model.addAttribute("autor","Gustavo Coronel");
		
		return "sumar";
	}
	
	@PostMapping("/sumar2")
	public String sumar2(String num1, String num2, Model model) {
		// Variables
		int nNum1, nNum2;
		try {
			// Datos
			nNum1 = Integer.parseInt(num1);
			nNum2 = Integer.parseInt(num2);
			// Proceso
			int suma = mateService.sumar(nNum1, nNum2);
			// Reporte
			model.addAttribute("num1", nNum1);
			model.addAttribute("num2", nNum2);
			model.addAttribute("suma", suma);
			model.addAttribute("estado",1);
		} catch (Exception e) {
			model.addAttribute("mensaje","Datos incorrectos.");
			model.addAttribute("estado",-1);
		}
		model.addAttribute("autor","Gustavo Coronel");
		return "sumar";
	}
	
}
