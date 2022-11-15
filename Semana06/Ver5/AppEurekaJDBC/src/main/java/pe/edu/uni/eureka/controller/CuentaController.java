package pe.edu.uni.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.uni.eureka.model.Empleado;
import pe.edu.uni.eureka.service.CuentaService;

@Controller
@RequestMapping("/cuenta")
@SessionAttributes({ "usuario" })
public class CuentaController {

	@Autowired
	private CuentaService cuentaService;

	@GetMapping("/crear")
	public String crear() {
		return "cuentaCrear";
	}

	@PostMapping("/crear")
	public String crear(@RequestParam("cliente") String cliente, 
			@RequestParam("moneda") String moneda,
			@RequestParam(name = "importe", required = false) Double importe, 
			@RequestParam("clave") String clave,
			Model model, @ModelAttribute("usuario") Empleado usuario) {
		model.addAttribute("titulo", "RESULTADO DEL PROCESO");
		try {
			String cuenta = cuentaService.crearCuenta(cliente, moneda, importe, clave, usuario.getCodigo());
			model.addAttribute("mensaje1", "Proceso ejecutado correctamente.");
			model.addAttribute("mensaje2", "Número de cuenta: " + cuenta);
		} catch (Exception e) {
			model.addAttribute("mensaje3", "Error en el proceso, intentelo de nuevo.");
			model.addAttribute("mensaje4", e.getMessage());
		}
		return "cuentaCrear";
	}

	@GetMapping("/depositar")
	public String depositar() {
		return "cuentaDeposito";
	}

	@GetMapping("/retiro")
	public String retiro() {
		return "cuentaRetiro";
	}

}
