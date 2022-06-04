package pe.edu.upc.StartUp.Elec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Business.Crud.BenefitService;


@Controller
@RequestMapping("/benefit")
public class BenefitController {

    @Autowired
    private BenefitService benefitService;

    @GetMapping
    public String index(Model model) {
        return "landingPage";
    }
}
