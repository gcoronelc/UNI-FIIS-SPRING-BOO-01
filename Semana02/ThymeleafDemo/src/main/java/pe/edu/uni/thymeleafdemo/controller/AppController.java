package pe.edu.uni.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.edu.uni.thymeleafdemo.model.BookModel;

@Controller
public class AppController {

	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("titulo", "SALUDO");
		model.addAttribute("mensaje", "Bienvenido a Thymeleaf.");
		model.addAttribute("book", new BookModel("Java Reactivo","Gustavo",200));
		
		List<BookModel> lista  = new ArrayList<>();
		lista.add(new BookModel("Java", "Elmer", 50));
		lista.add(new BookModel("Oracle", "Armando", 60));
		lista.add(new BookModel("Spring Boot", "Cyntia", 80));
		lista.add(new BookModel("SQL Server", "Nelson", 40));
		lista.add(new BookModel("Angular", "Mariela", 60));
		
		model.addAttribute("lista", lista);
		
		return "index";
	}
	
}
