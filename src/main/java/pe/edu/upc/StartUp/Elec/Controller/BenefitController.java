package pe.edu.upc.StartUp.Elec.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Business.Crud.BenefitService;
import pe.edu.upc.StartUp.Elec.Model.Entity.Benefit;


@Controller
@RequestMapping("/benefits")
@SessionAttributes("{benefit}")
public class BenefitController {

    @Autowired
    private BenefitService benefitService;

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

}
