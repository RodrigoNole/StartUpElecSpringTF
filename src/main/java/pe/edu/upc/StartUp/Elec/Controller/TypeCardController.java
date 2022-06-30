package pe.edu.upc.StartUp.Elec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Business.Crud.TypeCardService;
<<<<<<< Updated upstream:src/main/java/pe/edu/upc/StartUp/Elec/Controller/TypeCardController.java
=======
import pe.edu.upc.StartUp.Elec.Model.Entity.Customer;
import pe.edu.upc.StartUp.Elec.Model.Entity.Receipt;
import pe.edu.upc.StartUp.Elec.Model.Entity.TypeCard;

import java.util.List;
import java.util.Optional;
>>>>>>> Stashed changes:src/main/java/pe/edu/upc/StartUp/Elec/controller/TypeCardController.java


@Controller
@RequestMapping("/typeCard")
@SessionAttributes("{typeCard}")
public class TypeCardController {

    @Autowired
    private TypeCardService typeCardService;

    @GetMapping("new")
    public String newTypecard(Model model) {
    	TypeCard typeCard = new TypeCard();
        model.addAttribute("typeCard", typeCard);

        return "typeCards/new-typeCards";
    }
    
    @PostMapping("savenew")
    public String TypeCard(Model model, @ModelAttribute("typeCard") TypeCard typeCard) {
        
        return "redirect:/receipts";
    }
}
