package pe.edu.upc.StartUp.Elec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Model.Entity.Publication;
import pe.edu.upc.StartUp.Elec.Model.Entity.Receipt;
import pe.edu.upc.StartUp.Elec.Model.Response.Response;
import pe.edu.upc.StartUp.Elec.Service.ReceiptService;

import java.util.List;

@RestController
@RequestMapping("/receipt/")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @GetMapping
    public List<Receipt> getAll() {
        return receiptService.getAll();
    }

    @GetMapping("{month}")
    public List<Receipt> findByMonth(@PathVariable String month) {
        return receiptService.findByMonth(month);
    }

    @PostMapping
    public Response save(@RequestBody Receipt receipt) {
        receiptService.save(receipt);

        return Response.builder()
                .code("200")
                .message("Se guardo el registro exitosamente")
                .build();
    }

    @PutMapping
    public Response update(@RequestBody Receipt receipt) {
        receiptService.update(receipt);

        return Response.builder()
                .code("200")
                .message("Se actualizo el registro exitosamente")
                .build();
    }

    @DeleteMapping("{id}")
    public Response deleteById(@PathVariable("id") Integer id) {
        receiptService.deleteById(id);

        return Response.builder()
                .code("200")
                .message("Se elimino el registro exitosamente")
                .build();
    }
}
