package pe.edu.upc.StartUp.Elec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Business.Crud.CustomerService;
import pe.edu.upc.StartUp.Elec.Business.Crud.HomeService;
import pe.edu.upc.StartUp.Elec.Model.Entity.Customer;
import pe.edu.upc.StartUp.Elec.Model.Entity.Home;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/homes")
@SessionAttributes("{home}")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String listHome(Model model) {
        try {
            List<Home> homes = homeService.getAll();
            model.addAttribute("homes", homes);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "homes/list-homes";
    }

    @GetMapping("new")
    public String newHome(Model model) {
        Home home = new Home();
        model.addAttribute("home", home);

        return "homes/new-homes";
    }

    @PostMapping("savenew")
    public String Home(Model model, @ModelAttribute("home") Home home) {
        try {
            Home homeSaved = homeService.update(home);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/homes";
    }

    @GetMapping("{id}/edit")
    public String editHome(Model model, @PathVariable("id") Integer id) {
        try {
            if (homeService.existsById(id)) {
                Optional<Home> optional = homeService.findById(id);
                model.addAttribute("home", optional.get());
            } else {
                return "redirect:/homes";
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "homes/edit-homes";
    }

    @PostMapping("{id}/update")
    public String updateHome(Model model, @ModelAttribute("home") Home home,
                                 @PathVariable("id") Integer id) {
        try {
            if (homeService.existsById(id)) {
                homeService.update(home);
            } else {
                return "redirect:/homes";
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "redirect:/homes";
    }

    @GetMapping("{id}/del")
    public String deleteHomes(Model model, @PathVariable("id") Integer id) {
        try {
            if (homeService.existsById(id)) {
                homeService.deleteById(id);
            } else {
                return "redirect:/homes";
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "redirect:/homes";
    }

}
