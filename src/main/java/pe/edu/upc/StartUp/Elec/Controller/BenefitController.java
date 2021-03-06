package pe.edu.upc.StartUp.Elec.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Business.Crud.BenefitService;
import pe.edu.upc.StartUp.Elec.Business.Crud.CustomerService;
import pe.edu.upc.StartUp.Elec.Model.Entity.Benefit;
import pe.edu.upc.StartUp.Elec.Model.Entity.Customer;


@Controller
@RequestMapping("/benefits")
@SessionAttributes("{benefit}")
public class BenefitController {

    @Autowired
    private BenefitService benefitService;
    
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String listBenefit(Model model) {
    	try {
    	List<Benefit> benefits= benefitService.getAll();
    	model.addAttribute("benefits", benefits);
    	}catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "benefits/list-benefits";
    }

    @GetMapping("new")
    public String newBenefit(Model model) {
    	Benefit benefit =new Benefit();
    	model.addAttribute("benefit", benefit);
    	try {
			List<Customer> customers = customerService.getAll();
			model.addAttribute("customers", customers);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return "benefits/new-benefits";
    }
    
    @PostMapping("savenew")
    public String saveBenefit(Model model,@ModelAttribute("benefit")Benefit benefit) {
    	try{
    		Benefit benefitSaved= benefitService.save(benefit);
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	return "redirect:/benefits";
    }

    @GetMapping("{id}/edit")	
	public String editBenefit(Model model, @PathVariable("id") Integer id) {				
		try {
			if (benefitService.existsById(id)) {
				Optional<Benefit> optional = benefitService.findById(id);
				model.addAttribute("benefit", optional.get());
				List<Customer> customers = customerService.getAll();
				model.addAttribute("customers", customers);
			} else {
				return "redirect:/benefits";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "benefits/edit-benefits";
	}
    
    @PostMapping("{id}/update")	
	public String updateBenefit(Model model, @ModelAttribute("benefit") Benefit benefit, 
			@PathVariable("id") Integer id) {
		try {
			if (benefitService.existsById(id)) {
				benefitService.update(benefit);
			} else {
				return "redirect:/benefits";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/benefits";
	}
    
    @GetMapping("{id}/del")	
	public String deleteBenefit(Model model, @PathVariable("id") Integer id) {
		try {
			if (benefitService.existsById(id)) {
				benefitService.deleteById(id);
			} else {
				return "redirect:/benefits";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/benefits";
	}
}
