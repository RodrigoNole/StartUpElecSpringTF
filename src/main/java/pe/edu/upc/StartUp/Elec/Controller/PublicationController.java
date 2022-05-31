package pe.edu.upc.StartUp.Elec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Model.Entity.Publication;
import pe.edu.upc.StartUp.Elec.Model.Response.Response;
import pe.edu.upc.StartUp.Elec.Service.PublicationService;

import java.util.List;

@RestController
@RequestMapping("/publication/")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @GetMapping
    public List<Publication> getAll() {
        return publicationService.getAll();
    }

    @GetMapping("{name}")
    public List<Publication> findByName(@PathVariable String name) {
        return publicationService.findByName(name);
    }

    @PostMapping
    public Response save(@RequestBody Publication publication) {
        publicationService.save(publication);

        return Response.builder()
                .code("200")
                .message("Se guardo el registro exitosamente")
                .build();
    }

    @PutMapping
    public Response update(@RequestBody Publication publication) {
        publicationService.update(publication);

        return Response.builder()
                .code("200")
                .message("Se actualizo el registro exitosamente")
                .build();
    }

    @DeleteMapping("{id}")
    public Response deleteById(@PathVariable("id") Integer id) {
        publicationService.deleteById(id);

        return Response.builder()
                .code("200")
                .message("Se elimino el registro exitosamente")
                .build();
    }

}
