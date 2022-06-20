package pe.edu.upc.StartUp.Elec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Business.Crud.CustomerService;
import pe.edu.upc.StartUp.Elec.Model.Entity.Customer;

import java.util.List;
import java.util.Optional;

@Controller

@RequestMapping("/customers")
@SessionAttributes("{customer}")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping
    public String listCustomer(Model model) {
        try {
            List<Customer> customers= customerService.getAll();
            model.addAttribute("customers", customers);
        }catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "customers/list-customers";
    }

    @GetMapping("new")
    public String newCustomer(Model model) {
        Customer customer =new Customer();
        model.addAttribute("customer", customer);

        return "customers/new-customers";
    }

    @PostMapping("savenew")
    public String Customer(Model model,@ModelAttribute("customer")Customer customer) {
        try{
            Customer customerSaved = customerService.update(customer);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/customers";
    }

    @GetMapping("{id}/edit")
    public String editCustomer(Model model, @PathVariable("id") Integer id) {
        try {
            if (customerService.existsById(id)) {
                Optional<Customer> optional = customerService.findById(id);
                model.addAttribute("customer", optional.get());
            } else {
                return "redirect:/customers";
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "customers/edit-customers";
    }

    @PostMapping("{id}/update")
    public String updateCustomer(Model model, @ModelAttribute("customer") Customer customer,
                                @PathVariable("id") Integer id) {
        try {
            if (customerService.existsById(id)) {
                Customer customerSave = customerService.findById(id).get();
                customer.setHomes(customerSave.getHomes());
                customer.setBenefits(customerSave.getBenefits());
                customer.setPublications(customerSave.getPublications());
                customer.setTypeCards(customerSave.getTypeCards());
                customerService.update(customer);
            } else {
                return "redirect:/customers";
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "redirect:/customers";
    }

    @GetMapping("{id}/del")
    public String deleteCustomer(Model model, @PathVariable("id") Integer id) {
        try {
            if (customerService.existsById(id)) {
                customerService.deleteById(id);
            } else {
                return "redirect:/customers";
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "redirect:/customers";
    }

}
