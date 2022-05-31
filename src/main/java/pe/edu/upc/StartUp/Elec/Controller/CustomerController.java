package pe.edu.upc.StartUp.Elec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Model.Entity.Customer;
import pe.edu.upc.StartUp.Elec.Model.Response.Response;
import pe.edu.upc.StartUp.Elec.Service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }
    @GetMapping("{dni}")
    public List<Customer> findByDni(@PathVariable Integer dni) {
        return customerService.findByDni(dni);
    }

    @PostMapping
    public Response save(@RequestBody Customer customer) {
        customerService.save(customer);

        return Response.builder()
                .code("200")
                .message("Se guardo el registro exitosamente")
                .build();
    }

    @PutMapping
    public Response update(@RequestBody Customer customer) {
        customerService.update(customer);

        return Response.builder()
                .code("200")
                .message("Se actualizo el registro exitosamente")
                .build();
    }

    @DeleteMapping("{id}")
    public Response deleteById (@PathVariable("id") Integer id){
        customerService.deleteById(id);

        return Response.builder()
                .code("200")
                .message("Se elimino el registro exitosamente")
                .build();
    }
}
