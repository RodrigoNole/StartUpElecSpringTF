package pe.edu.upc.StartUp.Elec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publicacion")
public class PublicationController {
	@GetMapping
	public String publicacion() {
		return "publication";
	}
}
