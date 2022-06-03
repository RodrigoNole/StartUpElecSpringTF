package pe.edu.upc.StartUp.Elec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Service.PublicationService;

import java.util.List;

@Controller
@RequestMapping("/publication/")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;



}
