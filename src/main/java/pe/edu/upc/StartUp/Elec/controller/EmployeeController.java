package pe.edu.upc.StartUp.Elec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.StartUp.Elec.business.crud.EmployeeService;
import pe.edu.upc.StartUp.Elec.model.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public String listEployees(Model model) {
		try {
			List<Employee> employees=employeeService.getAll();
			model.addAttribute("employees", employees);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "employees/list-employees";
	}
}
