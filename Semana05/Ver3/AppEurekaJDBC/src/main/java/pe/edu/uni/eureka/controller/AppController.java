package pe.edu.uni.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.uni.eureka.model.Empleado;
import pe.edu.uni.eureka.service.LogonService;

@Controller
@SessionAttributes({ "usuario" })
public class AppController {
	
	@Autowired
	private LogonService logonService;
	
	@GetMapping({"/","/index","/home"})
	public String home() {
		return "index";
	}
	
	@PostMapping("/logon")
	public String logon(String username, String password, Model model,
			@ModelAttribute("usuario") Empleado usuario) {
		usuario = logonService.validar(username, password);
		String destino;
		if(usuario==null) {
			destino = "index";
			model.addAttribute("mensaje", "Datos incorrectos.");
		} else {
			destino = "main";
			//model.addAttribute("bean", bean);
		}
		return destino;
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	@GetMapping("/pruebita")
	public String pruebita() {
		Empleado bean = logonService.validar("cromero", "chichos");
		if(bean!=null) {
			System.out.println("Hola: " + bean.getNombre());
		} else {
			System.out.println("No existe");
		}
		return "main";
	}

}
