package pe.edu.upc.StartUp.Elec.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.StartUp.Elec.Business.Crud.CustomerService;
import pe.edu.upc.StartUp.Elec.Business.Crud.EmployeeService;
import pe.edu.upc.StartUp.Elec.Business.Crud.PublicationService;

import pe.edu.upc.StartUp.Elec.Model.Entity.Customer;
import pe.edu.upc.StartUp.Elec.Model.Entity.Employee;
import pe.edu.upc.StartUp.Elec.Model.Entity.Publication;

@Controller
@RequestMapping("/publications")
@SessionAttributes("{publication}")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @Autowired
    private CustomerService customerService;
    
    @Autowired  
    private EmployeeService employeeService;
    
    @GetMapping
    public String listPublication(Model model) {
    	try {
    	List<Publication> publications= publicationService.getAll();
    	model.addAttribute("publications", publications);
    	}catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "publications/list-publications";
    }

    @GetMapping("new")
    public String newPublication(Model model) {
    	Publication publication =new Publication();
    	model.addAttribute("publication", publication);
    	try {
			List<Customer> customers = customerService.getAll();
			model.addAttribute("customers", customers);
			List<Employee> employees = employeeService.getAll();
			model.addAttribute("employees", employees);
			//esto ha cambiado
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return "publications/new-publications";
    }
    
    @PostMapping("savenew")
    public String savePublication(Model model,@ModelAttribute("publication")Publication publication) {
    	try{
    		Publication publicationSaved= publicationService.save(publication);
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	return "redirect:/publications";
    }
    
    @GetMapping("{id}/edit")	
   	public String editPublication(Model model, @PathVariable("id") Integer id) {				
   		try {
   			if (publicationService.existsById(id)) {
   				Optional<Publication> optional = publicationService.findById(id);
   				model.addAttribute("publication", optional.get());
   				List<Customer> customers = customerService.getAll();
   				model.addAttribute("customers", customers);
   				List<Employee> employees = employeeService.getAll();
   				model.addAttribute("employees", employees);
   				//esto has cambiado
   			} else {
   				return "redirect:/publications";
   			}
   			
   		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		return "publications/edit-publications";
   	}
    
    @PostMapping("{id}/update")	
   	public String updatePublication(Model model, @ModelAttribute("publication") Publication publication, 
   			@PathVariable("id") Integer id) {
   		try {
   			if (publicationService.existsById(id)) {
   				publicationService.update(publication);
   			} else {
   				return "redirect:/publications";
   			}
   			
   		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		return "redirect:/publications";
   	}
    
    @GetMapping("{id}/del")	
	public String deletePublication(Model model, @PathVariable("id") Integer id) {
		try {
			if (publicationService.existsById(id)) {
				publicationService.deleteById(id);
			} else {
				return "redirect:/publications";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/publications";
	}
}
