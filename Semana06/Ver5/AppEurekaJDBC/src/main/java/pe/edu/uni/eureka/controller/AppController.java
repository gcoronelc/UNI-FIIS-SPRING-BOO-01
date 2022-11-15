package pe.edu.uni.eureka.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.uni.eureka.model.Empleado;
import pe.edu.uni.eureka.service.CuentaService;
import pe.edu.uni.eureka.service.LogonService;

@Controller
@SessionAttributes({ "usuario" })
public class AppController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private LogonService logonService;
	
	@Autowired
	private CuentaService cuentaService;

	@GetMapping({ "/", "/index", "/home" })
	public String home() {
		return "index";
	}

	@PostMapping("/logon")
	public String logon(String username, String password, Model model, @ModelAttribute("usuario") Empleado usuario) {
		Empleado bean = logonService.validar(username, password);
		String destino;
		if (bean == null) {
			destino = "index";
			model.addAttribute("mensaje", "Datos incorrectos.");
		} else {
			destino = "main";
			usuario.setCodigo(bean.getCodigo());
			usuario.setNombre(bean.getNombre());
			usuario.setPaterno(bean.getPaterno());
			usuario.setMaterno(bean.getMaterno());
			usuario.setUsuario(bean.getUsuario());
		}
		return destino;
	}

	@GetMapping("/salir")
	public String salir(SessionStatus status) {
		status.setComplete();
		return "index";
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}

	@GetMapping("/pruebita")
	public String pruebita() {
		Empleado bean = logonService.validar("cromero", "chichos");
		if (bean != null) {
			System.out.println("Hola: " + bean.getNombre());
		} else {
			System.out.println("No existe");
		}
		/*
		String query = "select chr_sucucodigo from asignado a where a.chr_emplcodigo='0004' and dtt_asigfechabaja is null";
		String sucursal = jdbcTemplate.queryForObject(query, String.class);
		System.out.println("Sucursal: " + sucursal);
		*/
		// cuentaService.crearCuenta("00009", "01", 777, "56789", "0007");
		List<Map<String,Object>> lista = cuentaService.consultarMovimientos("01/11/2022", "15/11/2022");
		for(Map<String,Object> r: lista) {
			System.out.println(r.get("importe").toString());
		}
		
		return "main";
	}

	@ModelAttribute("usuario")
	public Empleado getUsuario() {
		Empleado usuario = new Empleado();
		usuario.setNombre("Alfa");
		return usuario;
	}

}
