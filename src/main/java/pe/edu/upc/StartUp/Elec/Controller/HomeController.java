package pe.edu.upc.StartUp.Elec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Model.Entity.Home;
import pe.edu.upc.StartUp.Elec.Model.Response.Response;
import pe.edu.upc.StartUp.Elec.Service.HomeService;

import java.util.List;

@RestController
@RequestMapping("/home/")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping
    public List<Home> getAll() {
        return homeService.getAll();
    }

    @PostMapping
    public Response save (@RequestBody Home home) {
        homeService.save(home);

        return Response.builder()
                .code("200")
                .message("Se guardo el registro exitosamente")
                .build();
    }

    @PutMapping
    public Response update(@RequestBody Home home) {
        homeService.update(home);

        return Response.builder()
                .code("200")
                .message("Se actualizo el registro exitosamente")
                .build();
    }

    @DeleteMapping("{id}")
    public Response deleteById (@PathVariable("id") Integer id){
        homeService.deleteById(id);

        return Response.builder()
                .code("200")
                .message("Se elimino el registro exitosamente")
                .build();
    }
}
