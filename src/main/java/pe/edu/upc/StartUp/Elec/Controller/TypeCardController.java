package pe.edu.upc.StartUp.Elec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Business.Crud.TypeCardService;


@Controller
@RequestMapping("/typeCard")
public class TypeCardController {

    @Autowired
    private TypeCardService typeCardService;


}
