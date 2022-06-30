package pe.edu.upc.StartUp.Elec.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Business.Crud.EmployeeService;

import pe.edu.upc.StartUp.Elec.Model.Entity.Employee;

@Controller
@RequestMapping("/employees")
@SessionAttributes("{employee}")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String listEmployee(Model model) {
    	try {
        	List<Employee> employees= employeeService.getAll();
        	model.addAttribute("employees", employees);
        	}catch(Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            return "employees/list-employees";
    }
    
    @GetMapping("new")
    public String newEmployee(Model model) {
    	Employee employee =new Employee();
    	model.addAttribute("employee", employee);
    	//acuerdate que aqui es donde deberia ir la otra tabla pero como no hay relacion asi se queda
    	return "employees/new-employees";
    }
    
    @PostMapping("savenew")
    public String saveEmployee(Model model,@ModelAttribute("employee")Employee employee) {
    	try{
    		Employee EmployeeSaved= employeeService.save(employee);
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	return "redirect:/employees";
    }
    
    @GetMapping("{id}/edit")	
   	public String editEmployee(Model model, @PathVariable("id") Integer id) {				
   		try {
   			if (employeeService.existsById(id)) {
   				Optional<Employee> optional = employeeService.findById(id);
   				model.addAttribute("employee", optional.get());
   				//aqui tambien
   			} else {
   				return "redirect:/employees";
   			}
   			
   		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		return "employees/edit-employees";
   	}
    
      
    @PostMapping("{id}/update")
    public String updateEmployee(Model model, @ModelAttribute("employee") Employee employee,
                                @PathVariable("id") Integer id) {
        try {
            if (employeeService.existsById(id)) {
                Employee employeeSave = employeeService.findById(id).get();
                employee.setHomes(employeeSave.getHomes());
                employee.setBenefits(employeeSave.getBenefits());
                employee.setPublications(employeeSave.getPublications());
                employee.setTypeCards(employeeSave.getTypeCards());
                
                employeeService.update(employee);
            } else {
                return "redirect:/employees";
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "redirect:/employees";
    }

    
    @GetMapping("{id}/del")	
   	public String deleteEmployee(Model model, @PathVariable("id") Integer id) {
   		try {
   			if (employeeService.existsById(id)) {
   				employeeService.deleteById(id);
   			} else {
   				return "redirect:/employees";
   			}
   			
   		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		return "redirect:/employees";
   	}
}
