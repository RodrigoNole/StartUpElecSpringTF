package pe.edu.upc.StartUp.Elec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Business.Crud.TypeCardService;
import pe.edu.upc.StartUp.Elec.Model.Entity.TypeCard;

@Controller
@RequestMapping("/typeCards")
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
