package pe.edu.upc.StartUp.Elec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejemplo")
public class ExampleController {

	@GetMapping
	public String ejemplo() {
		return "example";
	}
	
	@GetMapping("base")
	public String base() {
		return "layout/base";
	}
}
