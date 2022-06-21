package pe.edu.upc.StartUp.Elec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Business.Crud.TypeCardService;
import pe.edu.upc.StartUp.Elec.Model.Entity.Customer;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/typeCards")
@SessionAttributes("{typeCard}")
public class TypeCardController {

    @Autowired
    private TypeCardService typeCardService;


}
