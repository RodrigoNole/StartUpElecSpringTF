package pe.edu.upc.StartUp.Elec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Model.Entity.Benefit;
import pe.edu.upc.StartUp.Elec.Model.Response.Response;
import pe.edu.upc.StartUp.Elec.Service.BenefitService;

import java.util.List;

@RestController
@RequestMapping("/benefit/")
public class BenefitController {

    @Autowired
    private BenefitService benefitService;

    @GetMapping
    public List<Benefit> getAll() {
        return benefitService.getAll();
    }
    @GetMapping("{name}")
    public List<Benefit> findByName(@PathVariable String name) {
        return benefitService.findByName(name);
    }

    @PostMapping
    public Response save (@RequestBody Benefit benefit) {
       benefitService.save(benefit);

        return Response.builder()
                .code("200")
                .message("Se guardo el registro exitosamente")
                .build();
    }

    @PutMapping
    public Response update(@RequestBody Benefit benefit) {
        benefitService.update(benefit);

        return Response.builder()
                .code("200")
                .message("Se actualizo el registro exitosamente")
                .build();
    }

    @DeleteMapping("{id}")
    public Response deleteById (@PathVariable("id") Integer id){
        benefitService.deleteById(id);

        return Response.builder()
                .code("200")
                .message("Se elimino el registro exitosamente")
                .build();
    }


}
