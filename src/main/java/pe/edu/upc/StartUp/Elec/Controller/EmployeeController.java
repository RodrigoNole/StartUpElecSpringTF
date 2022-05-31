package pe.edu.upc.StartUp.Elec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Model.Entity.Employee;
import pe.edu.upc.StartUp.Elec.Model.Response.Response;
import pe.edu.upc.StartUp.Elec.Service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
    @GetMapping("{dni}")
    public List<Employee> findByDni(@PathVariable Integer dni) {
        return employeeService.findByDni(dni);
    }

    @PostMapping
    public Response save (@RequestBody Employee employee) {
        employeeService.save(employee);

        return Response.builder()
                .code("200")
                .message("Se guardo el registro exitosamente")
                .build();
    }

    @PutMapping
    public Response update(@RequestBody Employee employee) {
        employeeService.update(employee);

        return Response.builder()
                .code("200")
                .message("Se actualizo el registro exitosamente")
                .build();
    }

    @DeleteMapping("{id}")
    public Response deleteById (@PathVariable("id") Integer id){
        employeeService.deleteById(id);

        return Response.builder()
                .code("200")
                .message("Se elimino el registro exitosamente")
                .build();
    }
}
