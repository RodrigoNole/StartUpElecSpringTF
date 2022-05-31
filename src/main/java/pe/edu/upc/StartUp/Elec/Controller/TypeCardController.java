package pe.edu.upc.StartUp.Elec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Model.Entity.TypeCard;
import pe.edu.upc.StartUp.Elec.Model.Response.Response;
import pe.edu.upc.StartUp.Elec.Service.TypeCardService;

import java.util.List;

@RestController
@RequestMapping("/typeCard/")
public class TypeCardController {

    @Autowired
    private TypeCardService typeCardService;

    @GetMapping
    public List<TypeCard> getAll() {
        return typeCardService.getAll();
    }

    @PostMapping
    public Response save(@RequestBody TypeCard typeCard) {
        typeCardService.save(typeCard);

        return Response.builder()
                .code("200")
                .message("Se guardo el registro exitosamente")
                .build();
    }

    @PutMapping
    public Response update(@RequestBody TypeCard typeCard) {
        typeCardService.update(typeCard);

        return Response.builder()
                .code("200")
                .message("Se actualizo el registro exitosamente")
                .build();
    }

    @DeleteMapping("{id}")
    public Response deleteById(@PathVariable("id") Integer id) {
        typeCardService.deleteById(id);

        return Response.builder()
                .code("200")
                .message("Se elimino el registro exitosamente")
                .build();
    }
}
