package pe.edu.uni.restaurante.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pe.edu.uni.restaurante.model.ComboModel;
import pe.edu.uni.restaurante.model.RestauranteModel;
import pe.edu.uni.restaurante.service.RestauranteService;

@Controller
public class AppController {

	@Autowired
	private RestauranteService restauranteService;

	@GetMapping({"/","/home"})
	public String inicio(Model model) {
		model.addAttribute("control", 1);
		return "index";
	}

	@PostMapping("/procesar")
	public String procesar(@ModelAttribute RestauranteModel restauranteModel, Model model) {
		// Proceso
		restauranteModel = restauranteService.procesar(restauranteModel);
		// Reporte
		model.addAttribute("control", 2);
		model.addAttribute("bean", restauranteModel);
		return "index";
	}

	@ModelAttribute
	private void cargarCombos(Model model) {
		// Combo 1: Hospedaje
		List<ComboModel> hospedaje = new ArrayList();
		hospedaje.add(new ComboModel(0, "Seleccionar"));
		hospedaje.add(new ComboModel(1, "Clasico"));
		hospedaje.add(new ComboModel(2, "Ejecutivo"));
		hospedaje.add(new ComboModel(3, "Premium"));
		model.addAttribute("hospedaje", hospedaje);
		// Combo 2: Desayuno
		List<ComboModel> desayuno = new ArrayList();
		desayuno.add(new ComboModel(0, "Seleccionar"));
		desayuno.add(new ComboModel(1, "Regional - Básico"));
		desayuno.add(new ComboModel(2, "Regional - Clasico"));
		desayuno.add(new ComboModel(3, "Internacional"));
		model.addAttribute("desayuno", desayuno);
		// Combo 3: Almuerzo
		List<ComboModel> almuerzo = new ArrayList();
		almuerzo.add(new ComboModel(0, "Seleccionar"));
		almuerzo.add(new ComboModel(1, "Regional - Básico"));
		almuerzo.add(new ComboModel(2, "Regional - Clasico"));
		almuerzo.add(new ComboModel(3, "Internacional"));
		almuerzo.add(new ComboModel(4, "De la casa"));
		model.addAttribute("almuerzo", almuerzo);
		// Combo 4: Cena
		List<ComboModel> cena = new ArrayList();
		cena.add(new ComboModel(0, "Seleccionar"));
		cena.add(new ComboModel(1, "De la casa"));
		cena.add(new ComboModel(2, "Regional"));
		cena.add(new ComboModel(3, "Internacional"));
		model.addAttribute("cena", cena);
	}
}
