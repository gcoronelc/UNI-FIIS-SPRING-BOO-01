package pe.edu.uni.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pe.edu.uni.eureka.model.Cliente;
import pe.edu.uni.eureka.model.ClientePersistable;
import pe.edu.uni.eureka.service.ClienteService;

@Controller
public class AppController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping({"/","/index","/home"})
	public String home() {
		return "index";
	}
	
	@PostMapping("/logon")
	public String logon(String username, String password, Model model) {
		model.addAttribute("mensaje", "Pronto");
		return "main";
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	

}
