package pe.edu.upc.StartUp.Elec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empleado")
public class EmployeeController {

	@GetMapping
	public String empleado() {
		return "employee";
	}
}
